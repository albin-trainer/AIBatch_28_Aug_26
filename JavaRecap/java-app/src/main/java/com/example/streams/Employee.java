package com.example.streams;

public class Employee {
     private int empId;
    private String empName;
    private float salary;
    private String deptName;
    private String address;
    public Employee(int empId, String empName, float salary, String deptName, String address) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.deptName = deptName;
        this.address = address;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}
