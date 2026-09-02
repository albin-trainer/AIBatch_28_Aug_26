package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MethodRefDemo2 {
    //https://codeshare.io/albin_cg
    public static void main(String[] args) {
        ArrayList<Product> list= new ArrayList<>();
        list.add(new Product(101, "Laptop", 50000, 4.5f));
        list.add(new Product(102, "Bag", 500, 4.1f));
        list.add(new Product(103, "Mobile", 20000, 4.6f));
        list.add(new Product(104, "Shoes", 2000, 4.4f));
         //here logic is inside the lambda
      //  Comparator<Product> compare=(pr1,pr2)->pr1.getPrice()<pr2.getPrice()?-1:1;
       // Collections.sort(list,compare);
      //  Collections.sort(list, (pr1,pr2)->comparePrices(pr1, pr2));
        Collections.sort(list, MethodRefDemo2::comparePrices); //replaces the lambda 
        list.forEach(p-> System.out.println(p.getProdName()));
    }
    static int comparePrices(Product p1,Product p2){ 
        return p1.getPrice()<p2.getPrice()?-1:1;
    }
}
