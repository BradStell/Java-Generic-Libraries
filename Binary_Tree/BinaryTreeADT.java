import java.util.ArrayList;
import java.util.Iterator;

/**
* Interface:
*    Binary Tree for abstract data type T
*
*/
public interface BinaryTreeADT<T> {	
	
	/**
	 * Removes the calling nodes left subtree and reduces count accordingly
	 */
	public void removeLeftSubtree(); 
	
	/**
	 * Removes the calling nodes right subtree and reduces count accordingly
	 */
	public void removeRightSubtre();
	
	/**
	 * Removes all elements of the tree.
	 * Sets count to zero and root to null
	 */
	public void removeAllElements();
	
	/**
	 * Sends true if the tree is empty, false it it is full
	 * @return true if count is zero
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the size of the tree as in Number of nodes
	 */
	public int size();
	
	
	public boolean contains(T element);
	
	public T find (T element);
	
	public String toString();	
	
	/**
	 * In order Iterator
	 * Traverses Left, Visit, Right
	 */
	public Iterator<T> iteratorPreOrder();
	
	/**
	 * In order Iterator
	 * Traverses Left, Visit, Right
	 */
	public Iterator<T> iteratorInOrder();
	
	/**
	 * In order Iterator
	 * Traverses Left, Visit, Right
	 */
	public Iterator<T> iteratorPostOrder();
	
	public Iterator<T> iteratorLevelOrder();
}
