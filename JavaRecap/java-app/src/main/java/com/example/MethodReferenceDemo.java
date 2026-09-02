package com.example;
//https://codeshare.io/albin_cg
public class MethodReferenceDemo {
public static void main(String[] args) {
 // Task task=new Task();
   //Runnable r = ()->System.out.println("Child thread started");

    //Thread t=new Thread( ()-> doWork() );//new thread
    //Method Ref : alternative of lambda ....
    Thread t =new Thread(MethodReferenceDemo::doWork);
    t.start();//thread ready to run .....
    MethodReferenceDemo m=new MethodReferenceDemo();
    new Thread(m::doWork2).start();
    new Thread(MethodReferenceDemo::new).start();
}    
//this method signature exactly matching the run method
static void doWork(){
    System.out.println("Child thread started");
}
void doWork2(){
    System.out.println("Non static method");
}
MethodReferenceDemo(){ //this constructor exactly matching the run method 
    System.out.println("constructor ...");
}
}
