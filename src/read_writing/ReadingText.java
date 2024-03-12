package read_writing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingText {

	public static void main(String[] args) throws FileNotFoundException {
		
		File fileText = new File("in.txt");
		
		Scanner sc = new Scanner(fileText);
		
		System.out.println(sc.nextLine());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println();
		System.out.println("------");
		System.out.println();

		System.out.println("This is how you read from a text file, using Scanner and .next! ");
		System.out.println("------");
		
		sc.close();
		
		System.out.println();
		System.out.println("To read numbers from a file, we do the following...");
		
		File fileNumbers = new File("numbers.txt");
		sc = new Scanner(fileNumbers);
		
		int no1 = sc.nextInt();
		int no2 = sc.nextInt();
		int no3 = sc.nextInt();
		int no4 = no1 + no2 + no3;
	
		System.out.println("------");
		System.out.println("Number 1 = " + no1 + "\nNumber 2 = " + no2 + "\nNumber 3 = " + no3 + "\nCombined sum of all 3 numbers: " + no4);
		System.out.println("------");
		System.out.println("What we did was read the first 3 ints from the numbers.txt file,"
				+ "\nand made it print then show the combined total by creating a int no4!");
		System.out.println();
		System.out.println("Closing Program...");
		System.out.println("Program is now closed \nGoodbye");
		
		sc.close();

	}

}