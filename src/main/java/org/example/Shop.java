package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;
    private List<User> users;
    private List<Order> orders;
    private DeliverySystem deliverySystem;


    public Shop() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.deliverySystem = new DeliverySystem();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new Product("Milk", 50.0, "AB", 10,4.0));
        products.add(new Product("Water", 70.0, "XB", 15,3.0));
        products.add(new Product("Sweets", 73.0, "DB", 15,5.0));
        products.add(new Product("Soup", 20.0, "CB", 15,4.5));
        products.add(new Product("Ice cream", 40.0, "PB", 15,3.0));
        products.add(new Product("meat", 100.0, "LB", 15,4.7));
        products.add(new Product("Milk", 80.0, "AB", 15,4.7));
        products.add(new Product("Milk", 99.0, "AB", 15,4.7));
        // Добавление других товаров
    }

    public void displayAvailableProducts() {
        System.out.println("Available products:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Manufacturer: " + product.getManufacturer());
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public DeliverySystem getDeliverySystem() {
        return deliverySystem;
    }

    public List<Product> filterProducts(String keyword, double minPrice, double maxPrice, String manufacturer) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())
                    && product.getPrice() >= minPrice
                    && product.getPrice() <= maxPrice
                    && product.getManufacturer().equalsIgnoreCase(manufacturer)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
    public void displayFilteredProducts(List<Product> filteredProducts) {
        System.out.println("Filtered products:");
        for (Product product : filteredProducts) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Manufacturer: " + product.getManufacturer());
        }
    }
    public List<Product> recommendProducts(double minRating) {
        List<Product> recommendedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getRating() >= minRating) {
                recommendedProducts.add(product);
            }
        }
        return recommendedProducts;
    }
}
