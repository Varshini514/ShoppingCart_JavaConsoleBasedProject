package Java.Class;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String mobile;
    private String address;
    private List<String> orderDetails;

    // Constructor
    public User(String username, String mobile, String address) {
        this.username = username;
        this.mobile = mobile;
        this.address = address;
        this.orderDetails = new ArrayList<>();
    }

	public User() {
		// TODO Auto-generated constructor stub
	}

	// Getter and Setter for Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for Mobile
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // Getter and Setter for Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to add order details
    public void addOrderDetail(String orderDetail) {
        this.orderDetails.add(orderDetail);
    }

    // Method to get all order details
    public List<String> getOrderDetails() {
        return orderDetails;
    }

    // Display user details
    public void displayUserDetails() {
        System.out.println("Username: " + username);
        System.out.println("Mobile: " + mobile);
        System.out.println("Address: " + address);
        System.out.println("Order Details: ");
        
        if (orderDetails.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (String order : orderDetails) {
                System.out.println("- " + order);
            }
        }
    }

	public static boolean authenticateUser(String username2, String password) {
		
		return false;
	}

	public static void loadUserDatabase() {
		
		
	}

	public static void saveUserToFile(String username2, String password) {
		
		
	}
}
