package Java.Class;

import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {
	Scanner scan = new Scanner(System.in);

    HashMap<Integer, Integer> cartItems = new HashMap<>();
	private int quantity;
	private int productIDs;

	private int productID;
	
	private void setQuantity(int i) {
		this.quantity = quantity;
		
	}
    
    public String getName() {
        return getName();
    }
	
    public void addToCart(int productID, int quantity) {
        if (cartItems.containsKey(productID)) {
            int existingQuantity = cartItems.get(productID);
            cartItems.put(productID, existingQuantity + quantity);
        } else {
            cartItems.put(productID, quantity);
        }
    }
    
    public void buyNow(int quantity) {
    	
   	 System.out.print("Enter your username to confirm the order: ");
        String username = scan.next();
        
        int orderID = (int) (Math.random() * 10000); 
		
		ShoppingCart carts = null;
		Order or = new Order(orderID, username,carts);
        or.printInvoice();
        System.out.println("Order placed successfully!");
   	
   	
       if (quantity > 0 && quantity <= this.quantity) {
           ShoppingCart tempCart = new ShoppingCart();
           tempCart.addToCart(this.productID, quantity);

           String userName = "Guest"; 
           Order order = new Order((int) (Math.random() * 10000), userName, tempCart);
           order.printInvoice();

           setQuantity(this.quantity - quantity); 
			System.out.println("Order placed successfully for product: " + getName());
       } 
       else {
           System.out.println("Invalid quantity.");
       }
       }
       
    
       
       public void viewCart() {
           System.out.println("\nYour Shopping Cart:");
           if (cartItems.isEmpty()) {
               System.out.println("Cart is empty.");
               buyNow(quantity);
        }
       
        
           double totalCartPrice = 0.0;
           for (int productID : cartItems.keySet()) {
               Product product = Product.catalog.get(productID);
               int quantity = cartItems.get(productID);
               double totalPrice = product.getPrice() * quantity;

               System.out.println("Product: " + product.getName() +
                                  " | Quantity: " + quantity +
                                  " | Price per Item: ₹" + product.getPrice() +
                                  " | Total: ₹" + totalPrice);

               totalCartPrice += totalPrice;
           }

           System.out.printf("Total Cart Price: ₹%.2f%n", totalCartPrice);
           
    }

	public static void buyNow() {
		
	}

    }