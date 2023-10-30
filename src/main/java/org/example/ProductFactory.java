package org.example;

public class ProductFactory {
    public Product createProduct(String name, double price, String manufacturer, int quantity, double rating) {
        return new Product(name, price, manufacturer, quantity, rating);
    }
}