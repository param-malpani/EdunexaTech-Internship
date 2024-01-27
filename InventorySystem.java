package Simple_InventorySystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventorySystem {
    private static Map<String, Item> inventory = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Item\n2. Update Item\n3. View Items\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    updateItem(scanner);
                    break;
                case 3:
                    viewItems();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        if (inventory.containsKey(name)) {
            System.out.println("Item already exists in inventory. Updating quantity...");
            Item existingItem = inventory.get(name);
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            Item newItem = new Item(name, quantity);
            inventory.put(name, newItem);
            System.out.println("Item added to inventory.");
        }
    }
    
    private static void updateItem(Scanner scanner) {
        System.out.print("Enter item name to update: ");
        String name = scanner.nextLine();
        if (inventory.containsKey(name)) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); 
            Item item = inventory.get(name);
            item.setQuantity(newQuantity);
            System.out.println("Item quantity updated.");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    private static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Map.Entry<String, Item> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " - Quantity: " + entry.getValue().getQuantity());
            }
        }
    }
}

