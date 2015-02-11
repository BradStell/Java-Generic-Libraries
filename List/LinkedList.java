import java.util.Iterator;

/**
 * Abstract code for a linked list. Lists are implemented with linear nodes using generic data types.  
 * The user of this code can use any object without changing the code.  Does not contain an add method.
 * The user must extend this code and then either write code for an ordered list or unordered.
 * 
 * Implements: ListADT<T>, Iterable<T>
 *
 * 
 * @author Brad Stell
 * @version 10/15/2014
 *
 * @param <T>
 */
public abstract class LinkedList<T> implements ListADT<T>, Iterable<T> {
	
	
	/* Objects and Variables */
	
	protected int count;
	protected LinearNode<T> head, tail;
	
	
	/**
	 * Constructor:
	 * sets count equal to null and head and tail equal to null
	 */
	public LinkedList() {
		count = 0;
		head = tail = null;
	}

	
	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element in the list
	 */
	public T removeFirst() throws EmptyCollectionException{
		
		if (count == 0)
			throw new EmptyCollectionException("List is Empty.");
		T result = head.getElement();
		head = head.getNext();
		count--;
		if(count == 0)
			tail = null;
		
		return result;
	}

    /**  
     * Removes and returns the last element from this list. 
     *
     * @return the last element from this list
     */
    public T removeLast() {
	   
	    if (count == 0)
		    throw new EmptyCollectionException("List is Empty.");
	    T result = tail.getElement();
	   
	    LinearNode<T> current;
	    current = head;
	    while(current.getNext() != tail) {
		    current = current.getNext();
	    }
	    tail = current;
	    tail.setNext(null);
	    count--;
	   
	    return result;
    }

    /**  
     * Removes and returns the specified element from this list. 
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
    	
    	boolean found = false;
    	LinearNode<T> previous;
    	LinearNode<T> current;
    	
    	if (count == 0)
    		throw new EmptyCollectionException("Element Not In List.");
    	
    	previous = null;
    	current = head;
    	
    	while(current != null && !found) {
    		if(element.equals(current.getElement()))
    			found = true;
    		else {
    			previous = current;
    			current = current.getNext();
    		}
    	}
    	
    	if(!found)
    		throw new ElementNotFoundException("Element Not in List.");
    	else {
    		if(count == 1)
    			head = tail = null;
    		else if(current.equals(head))
    			head = current.getNext();
    		else if(current.equals(tail)){
    			tail = previous;
    			tail.setNext(null);
    		}
    		else
    			previous.setNext(current.getNext());
    	}
    	
    	count--;
    	
    	return current.getElement();
    }

    /**  
     * Returns a reference to the first element in this list. 
     *
     * @return a reference to the first element in this list
     */
    public T first() throws EmptyCollectionException {
    	
    	if(count == 0)
    		throw new EmptyCollectionException("Empty List.");
    	return head.getElement();
    }

    /**  
     * Returns a reference to the last element in this list. 
     *
     * @return a reference to the last element in this list
     */
    public T last() {
    	
    	if(count == 0)
    		throw new EmptyCollectionException("Empty List.");
    	return tail.getElement();
    }

    /**  
     * Returns true if this list contains the specified target element. 
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T element) {
    	
    	LinearNode<T> current;
    	current = head;
    	while(current != null && !(current.getElement().equals(element))) {
    		current = current.getNext();
    	}
    	
    	if(current != null)
    		return true;
    	else
    		return false;
    }

    /**  
     * Returns true if this list contains no elements. 
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
    	
    	return (count == 0);
    }

    /**  
     * Returns the number of elements in this list. 
     *
     * @return the integer representation of number of elements in this list
     */
    public int size() {
    	
    	return count;
    }

    /**  
     * Returns an iterator for the elements in this list. 
     *
     * @return an iterator over the elements in this list
     */
    @SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
    	
    	return new LinkedIterator<T>(head, count);
    }

    /**  
     * Returns a string representation of this list. 
     *
     * @return a string representation of this list
     */
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	String result;
    	LinearNode<T> current = head;
    	
    	while(current != null) {
    		sb.append(current.getElement() + "\n");
    		current = current.getNext();
    	}    
    	result = sb.toString();
    	return result;
    }
}

