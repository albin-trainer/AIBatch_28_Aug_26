package com.example.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsEx1 {
    public static void main(String[] args) {
       List<Employee> employees = Arrays.asList(

    new Employee(101, "Albin", 85000f, "IT", "Bangalore"),
    new Employee(102, "Priya", 65000f, "HR", "Chennai"),
    new Employee(103, "Rahul", 95000f, "IT", "Bangalore"),
    new Employee(104, "Sneha", 55000f, "Finance", "Mumbai"),
    new Employee(105, "Amit", 120000f, "IT", "Hyderabad"),
    new Employee(106, "Divya", 72000f, "HR", "Bangalore"),
    new Employee(107, "Karthik", 45000f, "Sales", "Chennai"),
    new Employee(108, "Anjali", 110000f, "IT", "Bangalore"),
    new Employee(109, "Vijay", 60000f, "Finance", "Pune"),
    new Employee(110, "Meena", 80000f, "Sales", "Bangalore"),
    new Employee(111, "Ajay", 50000f, "HR", "Hyderabad"),
    new Employee(112, "Swathi", 90000f, "Finance", "Bangalore"),
    new Employee(113, "Ravi", 75000f, "IT", "Chennai"),
    new Employee(114, "Deepa", 105000f, "Sales", "Bangalore"),
    new Employee(115, "Antony", 40000f, "HR", "Kochi")
);
//find the avg salary of bangalore emps
double avgSal=
employees.stream().
filter(p->p.getAddress().equals("Bangalore")).
mapToDouble(emp->emp.getSalary()).average().getAsDouble();

System.out.println(avgSal);

int sum=IntStream.of(1,2,3,4,5).sum();
System.out.println(sum);
sum=Stream.of(1,2,3,4,5).mapToInt(a->a).sum();
System.out.println(sum);
    }
}
