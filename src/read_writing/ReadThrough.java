package read_writing;

import java.io.FileWriter;
import java.io.IOException;



public class ReadThrough {
	public static void main (String [] args) throws IOException {
		
		//WRITING TO TEXT FILE
				FileWriter fw = new FileWriter("write.txt");
				
				

				fw.write("This will be written info the file writing.txt!");
				fw.write("\nNumbers work to: 1,2,3,4,5");
				System.out.println("Open the write.txt File to make sure text has been \nwritten after running code.");
				
				fw.close();

	}

}
