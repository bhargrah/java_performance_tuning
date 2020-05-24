package com.bhargrah.energymart.datasource;

import com.bhargrah.energymart.model.ElectricityReading;
import com.bhargrah.energymart.model.UserAccount;
import com.bhargrah.energymart.util.ElectricityReadingsGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component
public class ElectricityReadings {
    private Map<String, List<ElectricityReading>> meterAssociatedReadings;

    private Accounts accounts;

    @Autowired
    public ElectricityReadings(Accounts accounts) {
        this.accounts = accounts;
    }

    @PostConstruct // generating dummy data for Meter Reading
    public void init() {
        meterAssociatedReadings = ElectricityReadingsGenerator.generateMeterReadings(accounts);
    }


    public List<ElectricityReading> getReadingsForMeter(String meterId) {
        return meterAssociatedReadings.containsKey(meterId) ? meterAssociatedReadings.get(meterId) : new ArrayList<>();
    }

    public void add(ElectricityReading reading) {
        meterAssociatedReadings.computeIfAbsent(reading.getMeterId(), r -> new ArrayList<>()).add(reading);
    }
}
