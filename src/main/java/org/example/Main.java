package org.example;

import java.util.*;

//Где я применял SOLID будет написано здесь, чтобы не писать в каждом классе конкретно. Для удобства.
/*
Принцип единственной обязанности:

Класс Shop отвечает только за управление товарами в магазине.
Класс Cart управляет функциональностью корзины пользователей.
Класс Order отвечает за управление заказами.

Принцип открытости/закрытости :

Классы Shop, Cart, Order и другие можно легко расширить без изменения их основной реализации. Новые методы могут быть добавлены без изменения кода.

Принцип подстановки Лисков:

Классы Cart и Shop могут быть использованы взаимозаменяемо, так как они оба отвечают за разные аспекты магазина, и их функциональность не конфликтует друг с другом.

Принцип разделения интерфейса :
В пример можно привести класс Shop в котором только необходимые методы для управления товарами и нет ненужных методов.


 */
public class Main {
    public static void main(String[] args) {
        //// Избегание магических чисел: Константа 8 используется для выхода из цикла приложения
              // и указана в качестве условия выхода из цикла
        Shop shop = new Shop();
        User user = new User("Ivan Ivanov", "ivanivanov@example.com", new Cart(new ArrayList<>()));

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.FRANCE);// это было сделано для того чтобы точно знать как вводить double через точку или запятую в консоли
        int choice = 0;
        while (choice != 8) {
            System.out.println("1. Display available products");
            System.out.println("2. Filter products");
            System.out.println("3. Add product to cart");
            System.out.println("4. Remove product from cart");
            System.out.println("5. Track order");
            System.out.println("6. Recommend products");
            System.out.println("7. Display cart");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Использование DRY: Метод displayAvailableProducts используется для отображения доступных продуктов
                    //и только он занимается этим.
                    shop.displayAvailableProducts();
                    shop.displayAvailableProducts();
                    break;
                case 2:
                    System.out.print("Enter keyword: ");
                    String keyword = scanner.next();
                    System.out.print("Enter min price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter max price: ");
                    double maxPrice = scanner.nextDouble();
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.next();
                    //только filterProducts используется для фильтрации продуктов.
                    //
                    List<Product> filteredProducts = shop.filterProducts(keyword, minPrice, maxPrice, manufacturer);
                    shop.displayFilteredProducts(filteredProducts);
                    break;
                case 3:
                    System.out.println("Enter the number of the product to add to cart: ");
                    int productIndex = scanner.nextInt();
                    if (productIndex >= 0 && productIndex < shop.getProducts().size()) {
                        Product selectedProduct = shop.getProducts().get(productIndex);
                        user.getCart().addProduct(selectedProduct);
                        System.out.println("Product added to cart: " + selectedProduct.getName());

                        System.out.println("Do you want to repeat the order? (1 for yes, 0 for no)");
                        int repeatOrderChoice = scanner.nextInt();
                        if (repeatOrderChoice == 1) {
                            user.getCart().addProduct(selectedProduct);
                            System.out.println("Product added to cart: " + selectedProduct.getName() + " (Repeated Order)");
                        } else if (repeatOrderChoice == 0) {
                            //ничего
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the number of the product to remove from cart: ");
                    int productIndexToRemove = scanner.nextInt();
                    if (productIndexToRemove >= 0 && productIndexToRemove < user.getCart().getProducts().size()) {
                        Product productToRemove = user.getCart().getProducts().get(productIndexToRemove);
                        user.getCart().removeProduct(productToRemove);
                        System.out.println("Product removed from cart: " + productToRemove.getName());
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 5:
                    if (user.getCart().getProducts().isEmpty()) {
                        System.out.println("No products in the cart. Add some products to track the order.");
                    } else {
                        Order currentOrder = new Order(user, user.getCart());
                        String orderStatus = shop.getDeliverySystem().trackOrderStatus(currentOrder);
                        System.out.println("Order status: " + orderStatus);
                    }
                    break;
                case 6:
                    // Использование DRY: Метод recommendProducts используется для рекомендации продуктов
                    System.out.print("Enter the minimum rating for recommended products: ");
                    double minRating = scanner.nextDouble();

                    try {
                        List<Product> recommendedProducts = shop.recommendProducts(minRating);
                        if (recommendedProducts.isEmpty()) {
                            System.out.println("No recommended products with the given rating threshold.");
                        } else {
                            System.out.println("Recommended products:");
                            for (Product recommendedProduct : recommendedProducts) {
                                System.out.println("Name: " + recommendedProduct.getName() + ", Price: " + recommendedProduct.getPrice() +
                                        ", Manufacturer: " + recommendedProduct.getManufacturer() + ", Rating: " + recommendedProduct.getRating());
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    System.out.println(minRating);
                    break;
                case 7:
                    // Использование DRY: Метод displayCart используется для отображения содержимого корзины
                    if (user.getCart().getProducts().isEmpty()) {
                        System.out.println("No products in the cart. Add some products to view the cart.");
                    } else {
                        System.out.println("Current Cart:");
                        List<Product> cartProducts = user.getCart().getProducts();
                        for (Product cartProduct : cartProducts) {
                            System.out.println("Name: " + cartProduct.getName() + ", Price: " + cartProduct.getPrice());
                        }
                        System.out.println("Total price: " + user.getCart().getTotalPrice());
                    }
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}