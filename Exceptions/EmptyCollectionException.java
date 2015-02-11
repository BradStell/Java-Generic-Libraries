/**
 * Represents the situation in which a collection is empty.
 *
 * @author Brad Stell
 * @version 11-10-2014
 */
public class EmptyCollectionException extends RuntimeException
{
    /**
     * Accepts a message to be displayed
     * @param String, message to be displayed
     */
    public EmptyCollectionException(String msg)
    {
        System.out.print(msg);
    }
}
