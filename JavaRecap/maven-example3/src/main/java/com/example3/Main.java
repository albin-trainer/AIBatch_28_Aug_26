package com.example3;

import com.example.EmployeeProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EmployeeProfile emp=new EmployeeProfile(1, "test", "test@test.com");
        System.out.println(emp.extractUserNameFromEmail());
    }
}