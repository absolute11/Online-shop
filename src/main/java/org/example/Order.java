package org.example;

public class Order {
    private User user;
    private Cart cart;
    private String status;

    public Order(User user, Cart cart) {
        this.user = user;
        this.cart = cart;
        this.status = "Pending";
    }

    public void returnOrder() {
        this.status = "Returned";
    }

}
