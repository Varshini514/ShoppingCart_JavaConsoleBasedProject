package Java.Class;

import java.util.Scanner;

public class ShoppingApp {

    private static ShoppingCart shoppingCart = new ShoppingCart();

    public static void main(String[] args) {
        User.loadUserDatabase();
        Product.initializeCatalog();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Spark & Shop");
        String username = "";
        String password = "";
        
        System.out.println("Are you new or existing customer:");
        System.out.println("1.Existing Customer");
        System.out.println("2.New Customer");
        System.out.println("Enter your Option: ");
        
        int option = scan.nextInt();
        scan.nextLine();
        switch(option) {
        case 1: 
        	System.out.print("Enter Username: ");
            username = scan.nextLine();
            System.out.print("Enter Password: ");
            password = scan.nextLine();

            if (User.authenticateUser(username, password)) {
                System.out.println("Login Successful!");
            } 
            else {
                System.out.println("Invalid Username or Password!");
            }
            break;
        
            
        case 2: 
        	System.out.println("\nCreate a New Account");
            username = getNewUserInput("Enter Username: ", scan);
            password = getNewUserInput("Enter Password: ", scan);

            User.saveUserToFile(username, password);
            System.out.println("Account created successfully!");
            break;
        }
        
        showMenu(scan);
        scan.close();
 
}

    private static String getNewUserInput(String prompt, Scanner scan) {
        System.out.print(prompt);
        return scan.nextLine();
    }

    public static void showMenu(Scanner scan) {
        while (true) {
            System.out.println("\nServices Available:");
            System.out.println("1. Shop Now");
            System.out.println("2. View My Cart");
            System.out.println("3. User Details");
            System.out.println("4. Exit");
            System.out.print("Choose Your Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();  // Clear the newline character from the buffer

            switch (choice) {
                case 1:
                    shopNow(scan);
                    break;
                case 2:
                    shoppingCart.viewCart();
                    break;
                case 3:
                	User us = new User();
                	us.displayUserDetails();
                	break;
                case 4:
                    System.out.println("Thank you for shopping with us!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

	private static void shopNow(Scanner scan) {
        System.out.println("\nAvailable Products:");
        for (Product product : Product.catalog.values()) {
            System.out.println(product);
        }

        System.out.println("Your Choices");
        System.out.println("1.Add to cart");
		System.out.println("2.Buy Now");
		System.out.println("Enter your Option:"); 
		int opt = scan.nextInt();
		
		
		switch(opt) {
		case 1:
			System.out.print("Enter Product ID to add to cart: ");
            int productID = scan.nextInt();
            scan.nextLine();  // Clear the newline character from the buffer

            Product product1 = Product.catalog.get(productID);
            if (product1 == null) {
                System.out.println("Product not found.");
                return;
            }

            System.out.print("Enter the Quantity: ");
            int quantity = scan.nextInt();
            scan.nextLine();  // Clear the newline character from the buffer

            if (quantity <= 0) {
                System.out.println("Invalid quantity! Quantity must be greater than 0.");
            } else if (quantity <= product1.getQuantity()) {
                shoppingCart.addToCart(productID, quantity);
                product1.setQuantity(product1.getQuantity() - quantity);
                System.out.println("Product added to cart!");
            } else {
                System.out.println("Requested quantity exceeds available stock.");
            }
            
		case 2:
			shoppingCart.buyNow();
		}
        }
    }


