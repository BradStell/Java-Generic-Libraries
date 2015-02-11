/**
 * 
 * This is the code implementing the Ordered List Abstract Data Type Interface.  It also extends the Array List Interface.
 * This code has access to all of the ArrayList's code plus this adds an add method.  The add method will put an object
 * into the array in order based on the comparable method.  All objects being sent into this class must be of type comparable.
 * 
 * @author Brad Stell
 * @version 10/15/2014
 *
 *Extends: ArrayList<T>
 *Implements: OrderedListADT<T>
 * 
 */
public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T> {
	
	/* Variables */
	
	T minElement;
	int startScan;
	int index;
	int minIndex;	
	
	/**
	 * Constructor: Calls constructor of super class (ArrayList)
	 */
	public OrderedArrayList() {
		super();
	}
	
	
	/**
	 * Add method:
	 * This method accepts a generic object and will put it into an ordered array in an ordered fashion.
	 * Objects being sent in must be of type comparable.  The compareTo() method is used to place an
	 * object into the list in the correct spot.
	 * 
	 * @params T (generic object)
	 */
	public void add(T element) {
		
		// If array is empty
		if (rear == 0)
			list[0] = element;
		else {			
			// Type cast object to type comparable to prevent compiler errors and runtime errors
			@SuppressWarnings("unchecked")
			Comparable<T> cElement = (Comparable<T>)element;
	        
			// If the list is full, call the expandCapacity method from the parent ArrayList class
			if (size() == list.length)
	            expandCapacity();	          
			
			// Find where the element belongs in the list
			int k = 0;
	        while (k < rear && cElement.compareTo(list[k]) > 0)
	            k++;

			// Once found, shift all elements from the found location and beyond up one array slot
	        for (int i = rear; i > k; i--)
	            list[i] = list[i-1];

			// Put element into the correct slot
	        list[k] = element;		
		}
		// Add one to rear
		rear++;
	}	
}