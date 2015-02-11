/**
 * Write a description of class ArrayStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ArrayStack<T> implements StackADT<T>
{
    
   // @SuppressWarnings("unchecked")
    private final int  DEFAULT_CAP = 100;
    private T[ ] stack;
    private int top;
    
    public ArrayStack( )
    {
        stack = (T[ ])new Object[DEFAULT_CAP];
        top = 0;
    }
    
    public ArrayStack(int capacity)
    {
        stack = (T[ ])new Object[capacity];
        top = 0;
    }
 

   /**  Adds one element to the top of this stack. */
   public void push (T element)
   {
       if(top == stack.length)//if current stack is full double size of the array
         expandCapacity( );
         
       stack[top] = element;
       top++;
    }
    
    private void expandCapacity( )
    {
        T[ ] temp  = (T[ ])new Object[stack.length * 2];
        for(int k = 0; k < stack.length; k++)
          temp[k] = stack[k];
        
          stack = temp;
   }


   public T pop()
   {
       T result;
       if(top == 0)
         throw new EmptyCollectionException("Trying to pop an empty stack");
       result = stack[--top];
       return result;
  }    
 
//  Returns without removing the top element of this stack. */
   public T peek()
   {
       if(top == 0)
         throw new EmptyCollectionException("Trying to peek at an empty stack.");
       return stack[top - 1];
    }
   
   /**  Returns true if this stack contains no elements. */
   public boolean isEmpty()
   {
       return top == 0;
    }
   /**  Returns the number of elements in this stack. */
   public int size()
   {
       return top;
    }
 
   /**  Returns a string representation of this stack. */
   public String toString()
   {
       String result = "";
       for(int k = 0; k < top; k++)
         result += stack[k] + "\n";
         
       return result;
    }


   
}
