/**
* Interface:
*   Binary Search Tree of generic data type T
*
* Extends: 
*   BinaryTreeADT<T> 
*/
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

	public void addElement(T element);
	
	public T removeElement(T element);
	
	public void removeAllOccurrences(T element);
	
	public T removeMin();
	
	public T removeMax();
	
	public T findMin();
	
	public T findMax();
	
}