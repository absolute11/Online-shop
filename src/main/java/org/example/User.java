package org.example;

public class User {
    private String name;
    private String email;
    private Cart cart;

    public User(String name, String email, Cart cart) {
        this.name = name;
        this.email = email;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
