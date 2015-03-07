/**
 * Read File
 *
 */

public static void readFileAtPath(String filename) {
		// Lets make sure the file path is not empty or null
		if (filename == null || filename.isEmpty()) {
			System.out.println("Invalid File Path");
			return;
		}
		String filePath = System.getProperty("user.dir") + "/" + filename;
		BufferedReader inputStream = null;
		// We need a try catch block so we can handle any potential IO errors
		try {
			try {
				inputStream = new BufferedReader(new FileReader(filePath));
				String lineContent = null;
				// Loop will iterate over each line within the file. // It will
				// stop when no new lines are found.
				
				HashSet<User> userHash = new HashSet<User>();
				List<User> itm = new ArrayList<User>();
				while ((lineContent = inputStream.readLine()) != null) {				
					
					User u = new User(lineContent);
					boolean exists = userHash.add(u);
					if (!exists) {						
						
						itm.add(u);
					}
					
				}
				Collections.sort(itm);
				for(int i = 0; i < itm.size(); i++)
				{
					System.out.print(itm.get(i).toString() + "\n");
				}
				
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		} // Make sure we close the buffered reader.

		catch (IOException e) {
			e.printStackTrace();
		}
		// end of method

	}

	public static List<T> getUniqueListFromFile(String filename, T type) {
		// Lets make sure the file path is not empty or null
		if (filename == null || filename.isEmpty()) {
			System.out.println("Invalid File Path");
			return;
		}
		String filePath = System.getProperty("user.dir") + "/" + filename;
		BufferedReader inputStream = null;
		// We need a try catch block so we can handle any potential IO errors
		try {
			try {
				inputStream = new BufferedReader(new FileReader(filePath));
				String lineContent = null;
				// Loop will iterate over each line within the file. // It will
				// stop when no new lines are found.
				
				HashSet<type> userHash = new HashSet<type>();
				List<type> itm = new ArrayList<type>();
				while ((lineContent = inputStream.readLine()) != null) {				
					
					type t = new type(lineContent);
					boolean exists = userHash.add(u);
					if (!exists) {						
						
						itm.add(u);
					}
					
				}
				Collections.sort(itm);
				
				return itm;
				
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		} // Make sure we close the buffered reader.

		catch (IOException e) {
			e.printStackTrace();
		}
		// end of method

	}