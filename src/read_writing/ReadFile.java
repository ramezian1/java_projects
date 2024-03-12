package read_writing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		File reader = new File("reader.txt");
		Scanner sc = new Scanner(reader);
		
		System.out.println(sc.nextLine());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		
		sc.close();
		
		File numbers = new File("numbers.txt");
		sc = new Scanner(numbers);
		
		
		System.out.println("------------------------");
		
		System.out.println(sc.nextInt());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		
		sc.close();
		
		//WRITING TO TEXT FILE
		FileWriter fw = new FileWriter("writing.txt");
		
		
		System.out.println("---------------------");
		System.out.println("Open the writing.txt File to make sure text has been \nwritten after running code.");
		fw.write("Peek-A-Boo!!!");
		
		fw.close();

	}

}