import java.io.*;
import java.util.*;

/**
 * Class OpenFile: Try catch block of verification code.  Determines if a file exists or not.
 * @author Brad Stell
 * @version 10/12/2014
 *
 */
public abstract class OpenFile {
	
	/**
	 * Static method, will determine if a particular file exists or not. 
	 * 		Will return null if file does not exist.
	 * @param String: A File Name.
	 * @return Returns a scanner object to the specified file.
	 * 		If file does not exist, scanner will be set to null.
	 */
	public static Scanner openFile(String fName) {
		
		Scanner ff;
		
		// Check and see if the file exists
		try {
			File file = new File(fName);
			ff = new Scanner(file);			
		}
		// If it does not exist, set the scanner equal to null
		catch (FileNotFoundException e) {
			ff = null;
		}
		
		return ff;
	}	
}
