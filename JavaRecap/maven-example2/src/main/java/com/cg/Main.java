package com.cg;

import com.example.EmployeeProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EmployeeProfile emp= new EmployeeProfile(1, "SaiKrishna", "saikkrishna@gapgemini.com");
        System.out.println(emp.extractUserNameFromEmail());
    }
}