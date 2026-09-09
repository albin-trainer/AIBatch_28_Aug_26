package com.example.springjwtsecurity;
import static org.mockito.ArgumentMatchers.matches;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = "cg";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
        String encodedPassword2 = encoder.encode(password);
        System.out.println(encodedPassword2);
       // $2a$10$de44RKSNdWtfQonKeHX66eDuQmUaonnJv3gHkm2H1mSAQglqL2EIW
        //version - 2a
        //load factor - 10
        //first 22 chars - salt
        //remaining is hashed pwd
        //based on version + load factor+salt  it again creates a new password for "cg"
      boolean t=  encoder.matches("cg", encodedPassword2); 
      System.out.println(t);
     
    }
}