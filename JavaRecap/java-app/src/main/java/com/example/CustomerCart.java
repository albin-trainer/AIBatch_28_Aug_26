package com.example;

import java.util.HashMap;

public class CustomerCart {
    private static HashMap<Product,Integer> items= new HashMap<>();
    static void addNewProduct(Product p){
        if (! items.containsKey(p)){
            items.put(p, 1);
           }
           else{
            int q=items.get(p);
            items.put(p, q+1); //just updating the quantity
           }
    }
    public static void main(String[] args) {
        addNewProduct(new Product(101, "Laptop", 50000, 4.5f));
        addNewProduct(new Product(101, "Laptop", 50000, 4.5f));
         addNewProduct(new Product(102, "Mobile", 20000, 4.6f));
        System.out.println("total products : "+items.size());
    }
}
class Product{
    private int id;
    private String prodName;
    private float price;
    private float ratings;
    public Product(int id, String prodName, float price, float ratings) {
        this.id = id;
        this.prodName = prodName;
        this.price = price;
        this.ratings = ratings;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((prodName == null) ? 0 : prodName.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        result = prime * result + Float.floatToIntBits(ratings);
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (prodName == null) {
            if (other.prodName != null)
                return false;
        } else if (!prodName.equals(other.prodName))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        if (Float.floatToIntBits(ratings) != Float.floatToIntBits(other.ratings))
            return false;
        return true;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getRatings() {
        return ratings;
    }
    public void setRatings(float ratings) {
        this.ratings = ratings;
    }
    
}
