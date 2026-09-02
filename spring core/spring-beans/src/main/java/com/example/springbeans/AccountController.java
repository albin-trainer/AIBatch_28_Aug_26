package com.example.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AccountController {
    private AccountService accountService;
    @Autowired
    //@Qualifier("getAccService")
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String credit(float amt) {
        if (accountService == null) {
            throw new IllegalStateException("AccountService not set");
        }
        return accountService.credit(amt);
    }
}
