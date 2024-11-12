package Java.Class;

import java.util.HashMap;

public class Product {
    public static HashMap<Integer, Product> catalog = new HashMap<>();

    private int productID;
    private String name;
    private double price;
    private int quantity;

    public Product(int productID, String name, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
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

    @Override
    public String toString() {
        return "Product ID: " + productID + " | Name: " + name + " | Price: ₹" + price + " | Available Stock: " + quantity;
    }

    // Initialize Catalog with 10 products
    public static void initializeCatalog() {
        catalog.put(1, new Product(1, "Laptop", 50000, 10));
        catalog.put(2, new Product(2, "Smartphone", 30000, 15));
        catalog.put(3, new Product(3, "Headphones", 3000, 30));
        catalog.put(4, new Product(4, "Smart Watch", 5000, 20));
        catalog.put(5, new Product(5, "Keyboard", 1500, 25));
        catalog.put(6, new Product(6, "Mouse", 800, 50));
        catalog.put(7, new Product(7, "Gaming Chair", 12000, 5));
        catalog.put(8, new Product(8, "Tablet", 20000, 8));
        catalog.put(9, new Product(9, "Wireless Speaker", 2500, 12));
        catalog.put(10, new Product(10, "Smart Bulb", 1200, 50));
    }
    
    }





