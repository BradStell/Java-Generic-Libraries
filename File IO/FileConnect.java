import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


/**
 * Class for handling file I/O
 * Will make BufferedReaders or Scanners both with File objects or Strings representing
 * the filepath/name.
 *
 * TODO Add file writing functionality
 */
public class FileConnect {

    /**
     * Returns a BufferedReader connected to the specified file
     * @param file
     * @return will be null if an error occured
     */
	public static BufferedReader getBufferedReader(String file) {

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

	
    /**
     * Returns a BufferedReader connected to the specified file
     * @param file
     * @return will be null if an error occured
     */
	public static BufferedReader getBufferedReader(File file) {

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

    /**
     * Returns a Scanner object connected to the specified filename
     * @param fileName -> the filename to be connected to, with a path if neccessary.
     *                 Will default to the root folder
     * @return Scanner object, or null if an error occured
     */
    public static Scanner getScanner(String fileName) {
        
        Scanner scan = null;

        try {
            File file = new File(fileName);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scan;
    }

    /**
     * Returns a Scanner object connected to the specified file
     * @param file -> file object to read from
     * @return Scanner object, or null if an error occured
     */
    public static Scanner getScanner(File file) {

        Scanner scan = null;

        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scan;
    }
	
}
