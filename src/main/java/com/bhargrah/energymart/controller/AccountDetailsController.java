package com.bhargrah.energymart.controller;

import com.bhargrah.energymart.datasource.Accounts;
import com.bhargrah.energymart.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountDetailsController {

    private Accounts accounts;

    @Autowired
    public AccountDetailsController(Accounts accounts) {
        this.accounts = accounts;
    }

    @GetMapping("/details/{accountId}")
    public ResponseEntity<UserAccount> getUserDetails(@PathVariable Integer accountId){
        return ResponseEntity.ok(accounts.getAccount(accountId));
    }

}
