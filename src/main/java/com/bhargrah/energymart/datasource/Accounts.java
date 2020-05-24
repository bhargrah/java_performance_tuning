package com.bhargrah.energymart.datasource;

import com.bhargrah.energymart.model.UserAccount;
import com.bhargrah.energymart.util.AccountGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Component
public class Accounts {
    private Map<Integer, UserAccount> userAccountsMap;

    private final PricePlans pricePlans;

    @Autowired
    public Accounts(PricePlans pricePlans) {
        this.pricePlans = pricePlans;
    }

    @PostConstruct // generating dummy account data
    public void init() {
        this.userAccountsMap = AccountGenerator.generateAccounts(this.pricePlans);
    }

    public UserAccount getAccount(int accountId) {
        return userAccountsMap.get(accountId);
    }

    public Optional<UserAccount> getAccountByMeterId(String meterId) {
        return userAccountsMap.values().stream().filter(userAccount -> userAccount.getMeterId().equals(meterId)).findFirst();
    }

    public Map<Integer, UserAccount> getUserAccountsMap() {
        return userAccountsMap;
    }
}
