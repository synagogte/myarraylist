

/*
 * Some things to consider for this lab:
 * 
 * Use the updated checkstyle.  
 * 
 * Java doesn't let us instantiate an array of type E so some casting will be needed
 * 
 * Some new tags and annotations you may like to use:
 * @param  <E> describes the specific type of data stored in the list.  
 * 
 * When casting carefully, you may not need Java's warning regarding unsafe or unchecked operations 
 * you may like to use the annotation @SuppressWarnings("unchecked")
 * Use this judiciously.   
 * 
 * In Javadocs use the tags either {@code text} or {@literal}.
 * to avoid html interpretations for example {@code 0 <= index <= size}
 * or use {@literal 0 <= index <= size}
 */
/**
 * Skeleton for MyArrayList lab.
 * 
 * @author Marina Peregrino
 * @version December 19, 2019
 * @author Syna Gogte
 * @version October 6, 2021
 */
public class MyArrayList<E> implements MyList<E>,  Iterable<E>
{
    private int size; 
    private Object[] info; 

    public MyArrayList()
    {
        size = 0; 
        info = new Object[10];
    }


    public int size()
    {
        return size; 
    }

    /*
     * appends obj to end of list; returns true
     */
    /**
     * 
     */
    public boolean add(E obj)
    {
        // // if values is already full, call doubleCapacity before adding 

        if (size == info.length)
            doubleCapacity(); 
        info[size] = (E) obj;
        size +=1; 
        return true; 
    
        
        
    }
    /*
     * precondition
     * {@code 0 <= index <= size}
     * 
     * inserts obj at position index,
     * moving elements at position index and higher
     * to the right (adds 1 to their indices) 
     * and adjusts size
     */
    /**
     * 
     */
    public void add(int index, E obj)
    {
        if (size == info.length)
            doubleCapacity(); 
        if (index > size)
            throw new IndexOutOfBoundsException(); 
        
        for (int i = size()-1; i>index-1; i--)
        {
            
            info[i+1] = info[i]; 
        }
        info[index] = (E) obj;
        size++;
    }

    /*
     * postcondition
     * replaces the array with one that is
     * twice as long, and copies all of the
     * old elements into it
     */

    private void doubleCapacity()
    {
        Object[] doubleCap = new Object[info.length*2]; 
        for (int i=0; i< info.length; i++)
        {
            doubleCap[i] = info[i];
        }
        info = doubleCap; 
    }
    /*
     * There is a precondition on @param index 
     */
    /**
     * 
     */
    public E get(int index)
    {
        if (index > size-1)
            throw new IndexOutOfBoundsException(); 
        return (E) info[index]; 

        // //(You will need to promise the return value is of type E.)
    }

    /*
     * returns the length of the array
     */
    public int getCapacity()
    {
        return info.length; 
    }

    /*
     * removes element from position index, 
     * moving elements at position index + 1 and higher 
     * to the left (subtracts 1 from their indices) 
     * and adjusts size
     * returns the element formerly at the specified position
     */
    /**
     * 
     */
    public E remove(int index)
    {
        if (index > size-1)
            throw new IndexOutOfBoundsException(); 
        E temp = (E) info[index];
        if(size>0)
        {
            for (int i = index; i<info.length-1; i++)
            {
                info[i] = info[i+1]; 
            }
        }
        info[size-1] = null; 
        size -= 1; 
        return temp; 

        // //(You will need to promise the return value is of type E.)
    }

    /*
     * replaces the element at position index with obj
     * returns the element formerly at the specified position
     */
    /**
     * 
     */
    public E set(int index, E obj)
    {
        if (index > size)
            throw new IndexOutOfBoundsException(); 
        E temp = (E) info[index]; 
        info[index] = (E) obj;
        return temp; 
        /*
        {
        if (size == info.length)
            doubleCapacity(); 
        
        E temp;  
        for (int i = size()-1; i<index; i--)
        {
            info[i+1] = info[i]; 
        }
        
        size+=1;  
        info[index] = (E) obj;
    }
        */


        // //(You will need to promise the return value is of type E.)
    }

    /**
     * 
     */
    public MyIterator<E> iterator()
    {
        return new MyArrayListIterator();
    }

    /**
     * 
     */
    public MyListIterator<E> listIterator()
    {
        return new MyArrayListIterator();
    }

    public String toString()
    {
        

        if (size == 0)
        {
            return "[]";
        }
        
        String s = "[";
        for (int i = 0; i < size - 1; i++)
        {
            s += info[i] + ", ";
        }
        return s + info[size - 1] + "]";
    }

    /**
     * Write a description of class x here.
     * 
     * @author Syna Gogte 
     * @version October 8, 2021
     */
    private class MyArrayListIterator<E> implements MyListIterator<E>
    {
        // //the index of the value that will be returned by next() 
        private int nextIndex;
        private int count; 

    
        public MyArrayListIterator()
        {
            nextIndex = 0;
            //count = 0; 
        }
        public void add(E obj)
        {

        }
        public void set(E obj) 
        {

        }
        public boolean hasNext()
        {
            return nextIndex<size; 
        }


        public E next()
        {
            
            E next = (E) info[nextIndex]; 
            nextIndex++; 
            return next; 
            

            // // (You will need to promise the return value is of type E.)
        }

        /*
         * removes the last element that was returned by next
         */

        public void remove()
        {
            if (nextIndex == 0)
                throw new IllegalStateException("have to call next"); 
            
            if(size>0)
            {
                for (int i = nextIndex; i<info.length-1; i++)
                {
                    info[i] = info[i+1]; 
                }
            }                
            info[size-1] = null; 
            size -= 1; 
          
               
        }
    }
}