package Java.Class;

public class Order {
    private int orderID;
    private String username;
    private ShoppingCart carts;

    public  Order(int orderID, String username, ShoppingCart cart) {
        this.orderID = orderID;
        this.username = username;
        this.carts = cart;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getUsername() {
        return username;
    }

    public ShoppingCart getCart() {
        return carts;
    }
    
    public void printInvoice() {
        System.out.println("\nOrder ID: " + orderID);
        System.out.println("Username: " + username);
        carts.viewCart(); 
        System.out.println("Thank you for your purchase!");
    }

}