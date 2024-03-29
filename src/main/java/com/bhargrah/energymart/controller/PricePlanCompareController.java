package com.bhargrah.energymart.controller;

import com.bhargrah.energymart.datasource.Accounts;
import com.bhargrah.energymart.model.PricePlan;
import com.bhargrah.energymart.model.Recommendation;
import com.bhargrah.energymart.model.RecommendedPlan;
import com.bhargrah.energymart.service.PricePlanService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plans")
public class PricePlanCompareController {
    private final PricePlanService pricePlanService;
    private final Accounts accounts;
    private final Timer responseTimer;
    private final Counter notFoundCounter;

    @Autowired
    public PricePlanCompareController(PricePlanService pricePlanService, Accounts accounts, MeterRegistry meterRegistry) {
        this.pricePlanService = pricePlanService;
        this.accounts = accounts;
        this.responseTimer = meterRegistry.timer("plans.recommend.responseTime");
        this.notFoundCounter = meterRegistry.counter("plans.recommend.notFoundCount");
    }

    @GetMapping("/recommend/{accountId}")
    public ResponseEntity<Recommendation> recommendPricePlans(@PathVariable Integer accountId,
                                                              @RequestParam(value = "limit", required = false) Integer limit) {
        long startTime = System.currentTimeMillis();

        try {
            Map<PricePlan, BigDecimal> consumptionCostForPricePlans = pricePlanService.get7DayCostOfElectricityForEachPricePlan(accountId);

            if (consumptionCostForPricePlans.isEmpty()) {
                notFoundCounter.increment();
                return ResponseEntity.notFound().build();
            }

            List<RecommendedPlan> recommendedPlans = consumptionCostForPricePlans.entrySet()
                    .stream()
                    .map(entry -> new RecommendedPlan(entry.getKey().getEnergySupplier(), entry.getKey().getPlanName(),
                            entry.getKey().getUnitRate(), entry.getKey().getRating(), entry.getValue()))
                    .collect(Collectors.toList());

            recommendedPlans.sort(Comparator.comparing(RecommendedPlan::getUsageCost));

            if (limit != null && limit < recommendedPlans.size()) {
                recommendedPlans = recommendedPlans.subList(0, limit);
            }

            return ResponseEntity.ok(
                    new Recommendation(accounts.getAccount(accountId).getPlanId(), recommendedPlans));
        } finally {
            responseTimer.record(System.currentTimeMillis() - startTime, TimeUnit.MILLISECONDS);
        }
    }
}
