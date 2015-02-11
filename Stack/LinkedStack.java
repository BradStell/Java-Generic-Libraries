
/**
 * Write a description of class LinkedStack here.
 * 
 * @author Brad Stell 
 * @version 12/11/14
 */
public class LinkedStack<T> implements StackADT<T>
{
   private LinearNode<T> top;
   private int count;
   
   LinkedStack( )
   {
       count = 0;
       top= null;
    }
    
    public void push(T element)
    {
        LinearNode<T> nln = new LinearNode<T>(element);
        nln.setNext(top);
        top = nln;
        count++;
    }
    
 
    public T pop()
    {
       
        if(count == 0)
         throw new EmptyCollectionException("In pop method");
         T result = top.getElement( );//save the data
         top = top.getNext( );
         count--;
         return result;
    }

  /**  Returns without removing the top element of this stack. */
   public T peek()
   {
       if(count == 0)
         throw new EmptyCollectionException("In peek method");
       
         return top.getElement( );
  }      
   
   /**  Returns true if this stack contains no elements. */
   public boolean isEmpty()
   {
       return count == 0;
    }    
   /**  Returns the number of elements in this stack. */
   public int size()
   {
       return count;
   }    
 
   /**  Returns a string representation of this stack. */
   public String toString()
   {
       String result = "";
       LinearNode<T> temp = top;
       
       for(int i = 0; i < count; i++)
       {
           result += temp.getElement( );
           temp = temp.getNext( );
        }    
        
        return result;
    }     
           
           
 }
