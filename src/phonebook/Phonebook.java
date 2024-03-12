package phonebook;

import java.io.*;
import java.util.*;

public class Phonebook {
    private static final String FILE_PATH = "phonebook.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Phonebook!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    searchContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Phonebook...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(name + ": " + phoneNumber);
            writer.newLine();
            System.out.println("Contact added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the contact.");
        }
    }

    private static void searchContact(Scanner scanner) {
     System.out.println("Enter the name to search: ");
     String nameToSearch = scanner.nextLine();
 
     try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
         boolean contactFound = false;
         while (fileScanner.hasNextLine()) {
             String line = fileScanner.nextLine();
             String[] parts = line.split(",");
             if (parts.length >= 2) {
                 String name = parts[0];
                 String phoneNumber = parts[1];
 
                 if (name.equalsIgnoreCase(nameToSearch)) {
                     System.out.println("Name: " + name + " , Telephone: " + phoneNumber);
                     contactFound = true;
                 }
             }
         }
 
         if (!contactFound) {
             System.out.println("Contact not found.");
         }
     } catch (FileNotFoundException e) {
         System.out.println("Phonebook file not found.");
     }
 }
 
    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter the name to delete: ");
        String nameToDelete = scanner.nextLine();

        try {
            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean contactFound = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];

                if (!name.equalsIgnoreCase(nameToDelete)) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    contactFound = true;
                }
            }

            writer.close();
            reader.close();

            if (contactFound) {
                if (inputFile.delete()) {
                    if (tempFile.renameTo(inputFile)) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("An error occurred while deleting the contact.");
                    }
               } else {
                    System.out.println("An error occurred while deleting the contact.");
                }
            } else {
                System.out.println("Contact not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the contact.");
        }
    }
}
