package com.bhargrah.energymart.model;

import java.math.BigDecimal;

public class RecommendedPlan {

    private final String planName;
    private final String energySupplier;
    private final BigDecimal usageCost; // for the past 7 days
    private final BigDecimal unitRate; // unit price per kWh
    private final Double rating;

    public RecommendedPlan(String energySupplier, String planName, BigDecimal unitRate, Double rating, BigDecimal usageCost) {
        this.energySupplier = energySupplier;
        this.planName = planName;
        this.unitRate = unitRate;
        this.rating = rating;
        this.usageCost = usageCost;
    }

    public String getPlanName() {
        return planName;
    }

    public String getEnergySupplier() {
        return energySupplier;
    }

    public BigDecimal getUsageCost() {
        return usageCost;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public Double getRating() {
        return rating;
    }
}
