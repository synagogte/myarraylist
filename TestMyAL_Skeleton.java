
/**
 * Demonstrates execution of each and every method within MyArrayList.  
 * 
 * @author Marina Peregrino  
 * @version 12 19, 2019     
 *          Created Skeleton to outline some basic tests for students to create.  
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestMyAL_Skeleton
{

    /**
     * Tests each of the methods for the MyArrayList: 
     * 
     * toString
     * size()
     * add(n)
     * add(i, n)
     * 
     * remove
     * set
     * get
     * 
     */
    public static void main (String [] args){ 
        /*
         * Things to consider:
         * What would be different for a Linked List?  
         */

        String studentName = "syna"; //Insert your name here.  
        System.out.println("Tests MyAL for "+ studentName); 
        
        // Test that MyArrayList implements the interface
        MyArrayList <Integer> nums1 = new MyArrayList<Integer>();

        /**
         * test1:  Tests for each of the following: 
         * add(i, n) to an empty list,
         * add(i, n) to an existing list,
         * size,
         * toString 
         */
        boolean test1 = true; 
        if (!test1)
            System.out.println ("Skipping Test #1"); 
        
        else
        {
            System.out.println ("#1 Testing: add at last index");
            
            for (int i=0; i < 5; i++)
            {
                
                nums1.add(i, i); 
                System.out.println ("" + nums1 + ", size: " + nums1.size());
            }
            

        }
        nums1= null;   

        /**
         * test2:  Tests for each of the following: 
         * add(n) to an empty list,
         * add(n) to an existing list,
         * size,
         * toString 
         */
        MyList<Integer> nums2 = new MyArrayList<Integer>();
        boolean test2 = true; 
        if (!test2){
            System.out.println ("Skipping Test #2"); 
        }
        else{
            System.out.println ("#2 Testing: add (appending)");
            for (int i=0; i < 5; i++)
            {
                nums2.add(2); 
                System.out.println ("" + nums2 + ", size: " + nums2.size());
            }
        }

        /**
         * test3:  Tests for each of the following: 
         * iterator,
         * hasNext,
         * next,
         */
        boolean test3 = true; 
        if (!test3){
            System.out.println ("Skipping Test #3"); 
        }
        else{
            /* */
            System.out.println ("List:\n" + nums2);
            System.out.println ("#3 Testing: iterator ");
            String s ="";
            MyArrayList<String> myAl = new MyArrayList<String>();
            MyIterator it = nums2.iterator(); 
            /*
            for (int num : nums2)
            {
                s = "num"; 
                System.out.println(s); 
            }
            System.out.println("hello"); 
            */
            /*
             * get an iterator 
             * loop through and get values from the iterator 
             * append the values to a String 
             */
            
            while(it.hasNext())
            {
                int val = (int) it.next(); 
                s += val + ", "; 
                //throw new RuntimeException("Write code to test MyArrayList");
            }

            
            System.out.println(" yields:");
            System.out.println(s);
            
            /* */
        }

        nums2= null;  //release unused data 
        //////////////////////////////////////////////////////////////////////

        /**
         * Previous tests were Integer list subsequent tests are String list
         * 
         * Add tests for the methods 
         * append,              
         * insert, 
         * remove, 
         * set, 
         * get
         * 
         * from begin, middle and end of list
         * 
         * test index out of bounds
         */
        MyArrayList<String> list = new MyArrayList<String>();

        /**
         * test4:  Tests for each of the following: 
         * 
         * append 
         * insert
         * 
         * 
         */
        boolean test4 = true; 
        if (!test4){
            System.out.println ("Skipping Test #4"); 
        }
        else{
            System.out.println("\n Other tests:");
            System.out.println("\n append:");
            for (int i=0; i < 5; i++)
            {
                list.add("hi " + i); 
                System.out.println (list);
            }
            System.out.println("\n insert:");
            list.add(1, "hello"); 
            System.out.println(list);
            System.out.println("\n remove:");
            list.remove(1); 
            System.out.println(list);


            //throw new RuntimeException("Write code to test MyArrayList");
        }

        /**
         * test5:  Tests for each of the following: 
         * 
         * set
         * get
         * remove
         * 
         */
        boolean test5 = true; 
        if (!test5){
            System.out.println ("Skipping Test #5"); 
        }
        else{
            System.out.println("\n More tests:");
            System.out.println("\n set");
            list.set(3, "hi 9"); 
            System.out.println(list);
            String s = list.get(3); 
            System.out.println(s); 
            // throw new RuntimeException("Write code to test MyArrayList");
        }

        /**
         * test6:  Tests exception for index out of bounds 
         * tests each of the methods that use index, 
         * add, remove, set, get
         * Tests when underlying array does have such and index and when it does not.   
         */
        boolean test6 = true; 
        if (!test6){
            System.out.println ("Skipping Test #6"); 
        }
        else{

            System.out.println("\n Test index out of bounds exception:");
            //throw new RuntimeException("Write code to test MyArrayList");
            
            try 
            {
                list.add(9, "hi 9"); 
                System.out.println(list);
            }
            catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            
            try 
            {
                list.remove(6);
            } 
            catch (IndexOutOfBoundsException e) 
            {
            System.out.println("" +  e );
            System.out.println("");
            }
            
            try 
            {
                list.set(7, "hi 7");
            } 
            catch (IndexOutOfBoundsException e) 
            {
            System.out.println("" +  e );
            System.out.println("");
            }
            
            try 
            {
                list.get(9); 
            } 
            catch (IndexOutOfBoundsException e) 
            {
            System.out.println("" +  e );
            System.out.println("");
            }
            /**/
        }
    }
}
