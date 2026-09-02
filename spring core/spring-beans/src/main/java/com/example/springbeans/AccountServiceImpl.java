package com.example.springbeans;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    private float balance = 0.0f;

    @Override
    public String credit(float amt) {
        balance += amt;
        return "Credited: " + amt + "; Balance: " + balance;
    }

    public float getBalance() {
        return balance;
    }
}
