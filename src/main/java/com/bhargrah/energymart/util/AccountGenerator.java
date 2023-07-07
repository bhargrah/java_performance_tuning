package com.bhargrah.energymart.util;

import com.bhargrah.energymart.datasource.PricePlans;
import com.bhargrah.energymart.model.PricePlan;
import com.bhargrah.energymart.model.UserAccount;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AccountGenerator {

    public static final Logger LOGGER = Logger.getLogger("com.bhargrah.energymart.util.AccountGenerator");

    public static Map<Integer, UserAccount> generateAccounts(PricePlans pricePlans) {

        LOGGER.info("Initializing User Accounts");

        int numAccountsToGenerate = 100_000;
        Map<Integer, UserAccount> userAccountMap = new HashMap<>(numAccountsToGenerate);

        Random random = new Random();
        List<String> planIds = pricePlans.getPricePlanList().stream().map(PricePlan::getPlanName).collect(Collectors.toList());

        for (int id = 0; id < numAccountsToGenerate; id++) {
            UserAccount userAccount = new UserAccount(id);

             userAccount.setMeterId("meter-" + id)
                        .setPlanId(planIds.get(random.nextInt(planIds.size())))
                        .setAccountType("BASIC")
                        .setUserJoinDate(ZonedDateTime.now(ZoneId.of("UTC")))
                        .setAccountStatus("ACTIVE");

            userAccountMap.put(id, userAccount);
        }

        LOGGER.info("Sample Account Details :"+userAccountMap.get(500).toString());

        LOGGER.info("User Accounts Initializing Completed");
        return userAccountMap;
    }

}
