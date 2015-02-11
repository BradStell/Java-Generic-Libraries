
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

	
	/**
	 * Adds the specified element in its proper in order slot
	 * @param T element to be added to Binary Search Tree
	 */
	public void addElement(T element) {
		
		BinaryTreeNode<T> btn = new BinaryTreeNode<T>(element);
		BinaryTreeNode<T> current;
		boolean placed = false;
		
		if (root == null) 
			root = btn;
		else {
			current = root;
			
			@SuppressWarnings("unchecked")
			Comparable<T> celement = (Comparable<T>)element;
			
			while (!placed) {
				if (celement.compareTo(current.element) < 0) {
					if (current.left == null) {
						current.left = btn;
						placed = true;
					}
					else 
						current = current.left;				
				}
				else {
					if (current.right == null) {
						current.right = btn;
						placed = true;
					}
					else
						current = current.right;
				}
			}			
		}
		
		count++;
	}
	
	/**
	 * Removes the specified element from the tree and returns it.  Reconnects tree around removed element to continue
	 * Binary tree order.
	 * @param T element to be removed
	 * @return T the element, if found
	 */	
	public T removeElement(T element) {
		
		BinaryTreeNode<T> current = root;
		BinaryTreeNode<T> parent = null;
		BinaryTreeNode<T> replace;
		@SuppressWarnings("unchecked")
		Comparable<T> celement = (Comparable<T>)element;
		T remove = null;
		boolean found = false;
		
		if (root == null) {
			remove = null;
		}
		else {
			for (int i = 0; i < count && !found; i++) {
				if (celement.compareTo(current.element) == 0) {
					found = true;
					remove = current.element;
					replace = replacement(current);
					
					if (replace == null){
						
						if (parent.left == current)							
							parent.left = null;
						else if (parent.right == current)							
							parent.right = null;					
						
						current = null;						
					}
					else {
						current.element = replace.element;
						current.right = (replace.right);
						current.left = (replace.left);
					}
					
					count--;
				}
				else {
					if (celement.compareTo(current.element) < 0) {
						parent = current;
						current = current.left;
					}
					else {
						parent = current;
						current = current.right;
					}
				}
			}
		}	
		
		return remove;
	}
	
	
	/**
     * Returns a reference to a node that will replace the one
     * specified for removal.  In the case where the removed node has 
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * @return a reference to the replacing node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) 
    {
        BinaryTreeNode<T> result = null;
        
        if ((node.left == null) && (node.right == null))
            result = null;
        
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        
        else if ((node.left == null) && (node.right != null))
            result = node.right;
        
        else
        {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            while (current.left != null)
            {
                parent = current;
                current = current.left;
            }
            
            current.left = node.left;
            if (node.right != current)
            {
                parent.left = current.right;
                current.right = node.right;
            }
            
            result = current;
        }
        
        return result;
    }
	
	public void removeAllOccurrences(T element) {
		
		BinaryTreeNode<T> current = root;
		BinaryTreeNode<T> replace;
		@SuppressWarnings("unchecked")
		Comparable<T> celement = (Comparable<T>)element;
		
		boolean found = false;		
		
		for (int i = 0; i < count && !found; i++) {
			
			if (celement.compareTo(current.element) == 0) {
				
				found = true;				
				replace = replacement(current);
				
				if (replace == null)
					current = null;
				else {
					current.element = replace.element;
					current.right = (replace.right);
					current.left = (replace.left);
				}
				
				count--;
			}
			else {				
				if (celement.compareTo(current.element) < 0)
					current = current.left;
				else
					current = current.right;
			}
		}
		
		if (celement.equals(current.element))
			removeAllOccurrences(element);
		
		if (!found)
			throw new ElementNotFoundException("Element Not in Tree");
			
	}
	
	
	public T removeMin() {
		
		BinaryTreeNode<T> current = root;
		BinaryTreeNode<T> replace;
		T min;
		
		if (root != null)
			current = current.left;
		
		min = current.element;
		replace = replacement(current);
		
		if (replace == null)
			current = null;
		else {
			current.element = replace.element;
			current.right = (replace.right);
			current.left = (replace.left);
		}
		
		return min;
	}
	
	public T removeMax() {
		
		BinaryTreeNode<T> current = root;
		BinaryTreeNode<T> replace;
		T max;
		
		if (root != null)
			current = current.right;
		
		max = current.element;
		replace = replacement(current);
		
		if (replace == null)
			current = null;
		else {
			current.element = replace.element;
			current.right = (replace.right);
			current.left = (replace.left);
		}
		
		return max;
	}
	
	public T findMin() {
		
		BinaryTreeNode<T> current = root;
		T min;
		
		if (root != null)
			current = current.left;
		
		min = current.element;
		
		return min;
		
	}
	
	public T findMax() {
		
		BinaryTreeNode<T> current = root;
		T max;
		
		if (root != null)
			current = current.right;
		
		max = current.element;
		
		return max;
	}
}
