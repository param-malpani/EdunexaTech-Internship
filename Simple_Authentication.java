package User_AuthenticationSystem;

import java.util.*;

public class Simple_Authentication {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, Boolean> loggedInUsers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nUser Authentication System");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Log Out");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    logoutUser();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userCredentials.containsKey(username)) {
            System.out.println("User already exists.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        userCredentials.put(username, password);

        System.out.println("User registered successfully.");
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!userCredentials.containsKey(username)) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String storedPassword = userCredentials.get(username);

        if (password.equals(storedPassword)) {
            loggedInUsers.put(username, true);
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid password.");
        }
    }

    private static void logoutUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!loggedInUsers.containsKey(username)) {
            System.out.println("User not logged in.");
            return;
        }

        loggedInUsers.remove(username);
        System.out.println("Logout successful.");
    }
}
