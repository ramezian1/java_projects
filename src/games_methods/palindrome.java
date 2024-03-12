package games_methods;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Enter a string to check for palindrome");
                System.out.println("2. Exit");

                // Read the user's choice
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    // Read a string from the user
                    System.out.print("Enter a string: ");
                    String input = scanner.nextLine();

                    // Remove spaces and convert to lowercase for a case-insensitive check
                    String cleanInput = input.replaceAll("\\s", "").toLowerCase();

                    // Check if it's a palindrome
                    if (isPalindrome(cleanInput)) {
                        System.out.println("The input is a palindrome.");
                    } else {
                        System.out.println("The input is not a palindrome. Please try again.");
                    }
                } else if (choice == 2) {
                    System.out.println("Exiting the program. Goodbye!");
                    break; // Exit the loop if the user chooses option 2
                } else {
                    System.out.println("Invalid choice. Please enter 1 to check for a palindrome or 2 to exit.");
                }
            }
        }
    }

    // Recursive function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int length = str.length();
        if (length <= 1) {
            return true;
        } else if (str.charAt(0) == str.charAt(length - 1)) {
            // Check the first and last characters
            // Recursively check the substring without these characters
            return isPalindrome(str.substring(1, length - 1));
        } else {
            return false;
        }
    }
}