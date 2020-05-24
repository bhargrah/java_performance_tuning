package com.bhargrah.energymart.service;

import com.bhargrah.energymart.datasource.Accounts;
import com.bhargrah.energymart.datasource.ElectricityReadings;
import com.bhargrah.energymart.model.ElectricityReading;
import com.bhargrah.energymart.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeterReadingService {
    private ElectricityReadings electricityReadings;
    private Accounts accounts;

    @Autowired
    public MeterReadingService(ElectricityReadings electricityReadings, Accounts accounts) {
        this.electricityReadings = electricityReadings;
        this.accounts = accounts;
    }

    public List<ElectricityReading> getReadings(int accountId) {
        UserAccount userAccount = accounts.getAccount(accountId);
        if (userAccount == null || userAccount.getMeterId() == null)
            return new ArrayList<>();

        String meterId = userAccount.getMeterId();
        return electricityReadings.getReadingsForMeter(meterId);
    }

    public void storeReading(ElectricityReading reading) {
        electricityReadings.add(reading);
    }
}
