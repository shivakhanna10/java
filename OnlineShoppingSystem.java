import java.util.*;
class Product {
    private String name;
    private double price;
    private int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
   
    public String toString() {
        return name + " (Price: $" + price + ", Quantity: " + quantity + ")";
    }
}
class Customer {
    private String name;
    private String email;
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}
class ShoppingCart {
    private List<Product> cart;
    private Customer customer;
    private static final double TAX_RATE = 0.08; // 8% tax
    private static final double DISCOUNT_10 = 0.10; // 10% discount for orders over $100
    private static final double DISCOUNT_20 = 0.20; // 20% discount for orders over $200
    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.cart = new ArrayList<>();
    }
    public void addProduct(Product product) {
        cart.add(product);
        System.out.println(product.getName() + " has been added to the cart.");
    }
    public void removeProduct(Product product) {
        cart.remove(product);
        System.out.println(product.getName() + " has been removed from the cart.");
    }
    public void displayCartContents() {
        System.out.println("Cart Contents for " + customer.getName() + ":");
        for (Product product : cart) {
            System.out.println(product);
        }
    }
    public double calculateTotalCost() {
        double subtotal = 0;
        for (Product product : cart) {
            subtotal += product.getPrice() * product.getQuantity();
        }
        double discount = 0;
        if (subtotal > 200) {
            discount = subtotal * DISCOUNT_20;        } else if (subtotal > 100) {
            discount = subtotal * DISCOUNT_10;
        }
        double tax = subtotal * TAX_RATE;
        double total = subtotal - discount + tax;
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: -$" + discount);
        System.out.println("Tax: +$" + tax);
        System.out.println("Total: $" + total);
        return total;
    }
    public void checkout() {
        System.out.println("Proceeding to checkout...");
        displayCartContents();
        calculateTotalCost();
    }
}
public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Create customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        // Create products
        Product product1 = new Product("Laptop", 999.99, 1);
        Product product2 = new Product("Headphones", 199.99, 1);
        Product product3 = new Product("Mouse", 49.99, 2);
        // Create shopping cart and add products
        ShoppingCart cart = new ShoppingCart(customer);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        // Display cart contents and checkout
        cart.displayCartContents();
        cart.checkout();
    }
}
