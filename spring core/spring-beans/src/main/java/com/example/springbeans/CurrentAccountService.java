package com.example.springbeans;

public class CurrentAccountService implements AccountService {
    private float balance = 0.0f;

    @Override
    public String credit(float amt) {
        balance += amt;
        return "CurrentAccount credited: " + amt + "; Balance: " + balance;
    }

    public float getBalance() {
        return balance;
    }
}
