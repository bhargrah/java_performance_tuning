package com.bhargrah.energymart.util;

import com.bhargrah.energymart.datasource.Accounts;
import com.bhargrah.energymart.model.ElectricityReading;
import com.bhargrah.energymart.model.UserAccount;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Logger;

public class ElectricityReadingsGenerator {

    public static final Logger LOGGER = Logger.getLogger("com.bhargrah.energymart.util.ElectricityReadingsGenerator");

    public static Map<String, List<ElectricityReading>> generateMeterReadings(Accounts accounts) {

        int numReadingsPerMeter = 20;
        Map<String, List<ElectricityReading>> meterReadings = new HashMap<>(accounts.getUserAccountsMap().size());

        for (UserAccount account : accounts.getUserAccountsMap().values()) {

            if(account.getId()%2000==0)
             LOGGER.info("Initializing Electricity Readings for user "+ account.getId());

            String meterId = account.getMeterId();

            Random readingRandomizer = new Random();
            Instant currentHour = Instant.now().truncatedTo(ChronoUnit.HOURS);
            List<ElectricityReading> readings = new ArrayList<>();

            for (int i = 0; i < numReadingsPerMeter; i++) {
                double reading = readingRandomizer.nextDouble() * 3;
                ElectricityReading electricityReading = new ElectricityReading(currentHour.minusSeconds(i * 3600),
                        BigDecimal.valueOf(reading), meterId);
                readings.add(electricityReading);
            }

            meterReadings.put(meterId, readings);
        }

        return meterReadings;
    }
}
