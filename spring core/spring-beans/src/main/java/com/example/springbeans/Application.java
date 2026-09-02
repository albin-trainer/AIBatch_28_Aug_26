package com.example.springbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SpringVersion;

public class Application {
    public static void main(String[] args) {
        //initialize the Spring application context from the XML configuration file
      //  ApplicationContext context =
        // new ClassPathXmlApplicationContext("beans.xml");
         ApplicationContext context =
          new AnnotationConfigApplicationContext(SpringConfig.class);
         AccountController accountController=
         context.getBean("accountController", AccountController.class);
         String resp=accountController.credit(10000);
         System.out.println(resp);

           AccountController accountController2=
         context.getBean("accountController", AccountController.class);
         System.out.println(accountController==accountController2); //chks the memory
    }
}
