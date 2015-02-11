/**
 *
 * @author Brad Stell
 * @version 1/13/2015
 *
 */
public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T>{
	
	public OrderedLinkedList() {
		super();
	}
	
	public void add(T element) {
		
		LinearNode<T> nln = new LinearNode<T>(element);
		LinearNode<T> current;
		LinearNode<T> previous = null;
		
		if(count == 0) 
			head = tail = nln;
		else {
			current = head;
			@SuppressWarnings("unchecked")
			Comparable<T> cElement = (Comparable<T>)element;
			while (current != null && cElement.compareTo(current.getElement()) > 0) {
				previous = current;
				current = current.getNext();
			}
			if (current == head) {
				nln.setNext(head);
				head = nln;
			}
			else if (current == null) {
				tail.setNext(nln);
				tail = nln;
			}
			else {
				previous.setNext(nln);
				nln.setNext(current);
			}
		}
		count++;
	}
}
