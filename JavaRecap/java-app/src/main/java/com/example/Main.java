package com.example;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Employee e1=new Employee(101, "Raj", 30000);
        Employee e2=new Employee(102, "Kiran", 40000);
        Employee e3=new Employee(103, "Sanjay", 25000);
        Employee e4=new Employee(101, "Raj", 30000);
        HashSet<Employee> set=new HashSet<>();
        set.add(e1);set.add(e2);set.add(e3);set.add(e4);
        System.out.println(set.size()); //4
        System.out.println(e1.hashCode());
        System.out.println(e4.hashCode());
        

    }
}