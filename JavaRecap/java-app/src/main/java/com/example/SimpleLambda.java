package com.example;

public class SimpleLambda {
    public static void main(String[] args) {
       // Greeting g = (String n)-> {return "Good morning "+n;};
      //  Greeting g = ( n)-> {return "Good morning "+n;};
       // Greeting g =  n-> {return "Good morning "+n;};
        Greeting g =  n->  "Good morning "+n;
        postWishes(g,"Albin");
        postWishes(n->"Have a Good day "+n, "Albin");
       
    }
    static void postWishes(Greeting g,String name){
        System.out.println(g.wish(name));
    }
}

@FunctionalInterface
interface Greeting{
    String wish(String name);
    //void f1();
}