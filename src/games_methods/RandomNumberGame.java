package games_methods;

import java.util.Scanner;

public class RandomNumberGame {
  public static void main(String[] args) {
    // Generate a random number between 1 and 100
    int randomNumber = (int) (Math.random() * 5) + 1;

    // Read an integer input from the user
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number between 1 and 5: ");
    int userNumber = scanner.nextInt();

    // Compare the user input to the random number
    if (userNumber == randomNumber) {
      System.out.println("Congratulations, you guessed the number!");
    } 
    else if (userNumber < randomNumber) {
      System.out.println("Your guess is too low, the number was " + randomNumber);
    } 
    
    else {
      System.out.println("Your guess is too high, the number was " + randomNumber);
    }
    scanner.close();
  }

}

        
        
