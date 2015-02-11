/**
 * UnorderedListADT defines the interface to an unordered list collection of abstract data type T. 
 * Elements are stored in any order the user desires.
 * 
 * Extends: ListADT<T>
 *
 * @author Brad Stell
 * @version 11-12-2014
 */
public interface UnorderedListADT<T> extends ListADT<T>
{
    /** Adds the specified element to the front of this list  */
    public void addToFront(T element);  

    /** Adds the specified element to the rear of this list. */
    public void addToRear(T element); 

    /** Adds the specified element after the specified target. */
    public void addAfter(T element, T target);
}
