package com.example;
public class EmployeeProfile {
private int empId;
private String empName;
private String email;
public EmployeeProfile(int empId, String empName, String email) {
    this.empId = empId;
    this.empName = empName;
    this.email = email;
}

//return Eg. email: raj@capgemini.com it shud return  "RAJ"
public String extractUserNameFromEmail(){
    String arr[]=  email.split("@");
    if(arr.length==2)
         return arr[0].toUpperCase();
    else
        return "Invalid Format";
}

}
