import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class FileConnect {

	public static BufferedReader openFile(String file) {

		/* File and Buffer Reader */
		FileReader fr;
		BufferedReader br = null;	
		
		
		try {			

            // Create File Reader with specified filename
			fr = new FileReader(file);

            // Create Buffered Reader with file reader
			br = new BufferedReader(fr);

			
		} catch (IOException e) {
            System.out.print("~~ \n\nFile Creation Failed ~~\n\n");
		} 
		
		return br;

	}

	public static BufferedReader openFile(File file) {

		/* File and Buffer Reader */
		FileReader fr;
		BufferedReader br = null;	
		
		
		try {			

            // Create File Reader with specified filename
			fr = new FileReader(file);

            // Create Buffered Reader with file reader
			br = new BufferedReader(fr);

			
		} catch (IOException e) {
            System.out.print("~~ \n\nFile Creation Failed ~~\n\n");
		} 
		
		return br;

	}
	
}
