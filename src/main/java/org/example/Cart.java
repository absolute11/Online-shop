package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public Cart(List<Product> products) {
        this.products = new ArrayList<>();
    }
    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
