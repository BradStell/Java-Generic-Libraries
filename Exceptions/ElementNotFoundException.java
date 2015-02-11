
/**
 * Exception class to throw when an element is not found
 * 
 * @author Brad Stell 
 * @version 11-10-2014
 */
public class ElementNotFoundException extends RuntimeException
{
	
	public ElementNotFoundException(String msg)
	{
		System.out.print(msg);
	}

 }