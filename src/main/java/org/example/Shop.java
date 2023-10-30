package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;
    private List<User> users;
    private List<Order> orders;
    private DeliverySystem deliverySystem;


    public Shop(ProductFactory productFactory) {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.deliverySystem = new DeliverySystem();
        initializeProducts(productFactory);
    }

    private void initializeProducts(ProductFactory productFactory) {
        products.add(productFactory.createProduct("Milk", 50.0, "AB", 10, 4.0));
        products.add(productFactory.createProduct("Water", 70.0, "GB", 15, 3.0));
        products.add(productFactory.createProduct("Ice cream", 120.0, "AB", 10, 4.0));
        products.add(productFactory.createProduct("Orange", 70.0, "CB", 15, 5.0));
        products.add(productFactory.createProduct("Fanta", 76.0, "AB", 10, 4.1));
        products.add(productFactory.createProduct("Sweets", 30.0, "AB", 15, 4.4));
        products.add(productFactory.createProduct("tomato", 20.0, "AB", 10, 4.0));
        products.add(productFactory.createProduct("cucumber", 70.0, "CB", 15, 3.0));
        products.add(productFactory.createProduct("Chocolate", 320.0, "AB", 10, 4.0));
        products.add(productFactory.createProduct("Ketchup", 70.0, "CB", 15, 3.0));

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
