/**
 * Exception class for when a list is empty
 * 
 * @author Brad Stell
 * @version 11-10-14
 */
public class EmptyListException extends RuntimeException
{
	/**
	* Accepts a message to be displayed to the screen
	*
	* @param String, message to be displayed
	*/
	public EmptyListException(String msg)
	{
		System.out.print(msg);
	}

 }