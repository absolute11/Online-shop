package org.example;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private String manufacturer;
    private int quantity;
    private double rating;
    private List<Integer> ratings;

    public Product(String name, double price, String manufacturer,int quantity,double rating) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.rating = rating;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public double getRating() {
        return rating;
    }
}
