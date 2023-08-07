import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
/**
 * SimpleTest tests basic operations for MyArrayList by comparing to Java's ArrayList.
 *
 * @author Marina Peregrino
 * @version Oct 2017
 */
public class SimpleTest_Iterator
{
    //determines whether it prints each operation
    private static final boolean VERBOSE = true;
    private static void show(Object s)
    {
        if (VERBOSE)
            System.out.println(""+s);
    }

    public static void moreTests(List real, MyList your){
        // test iterator remove  and remove state machine
        show("Compare the given lists:"); 
        show("your:  " + your);
        show("real:  " + real);   
        //         show("test add::::::::::");
        //         for(int i = 0; i < 15; i++)
        //         {
        //             int rand =(int) (Math.random() * 100);
        //             your.add(rand);
        //             real.add(rand);
        //             //show("\nyour:  " + your);
        //             //show("\nreal:  " + real);   
        //         }
        show("Iterator test add::::::::::");

        ListIterator<Integer> itReal = real.listIterator();
        MyListIterator<Integer> itYour = your.listIterator();
        for(int i = 0; i < 15; i++)
        {
            int rand =(int) (Math.random() * 100);
            itYour.add(rand);
            itReal.add(rand);
            if(!your.toString().equals(real.toString()))
            {
                show("There's a problem.");
                show("\nyour:  " + your);
                show("\nreal:  " + real);               

            }
            //show("\nyour:  " + your);
            //show("\nreal:  " + real);   
        }

        show ("after the add::::::::::");
        show("\nyour:  " + your);
        show("\nreal:  " + real);   

        show("\ntest add at index 0:");
        your.add(0, 1000);
        real.add(0, 1000);
        show("your:  " + your);
        show("real:  " + real);   

        show("test add at index 4:");
        your.add(4, 4444);
        real.add(4, 4444);
        show("your:  " + your);
        show("real:  " + real);   

        show("test add at last index:");
        your.add(your.size(), 9999);
        real.add(real.size(), 9999);

        show ("after the add:");
        show("\nyour:  " + your);
        show("\nreal:  " + real);   
        itReal = real.listIterator();
        itYour = your.listIterator();

        int index = -1;
        show("Iterator test remove:::::::::: ");
        while(itReal.hasNext() && itYour.hasNext())
        {
            itReal.next();
            itYour.next();
            index++;
            show (index + ", ");
            if(Math.random() > 0.5)
            {
                itReal.remove();
                itYour.remove();                    

                if(!your.toString().equals(real.toString()))
                {
                    show("There's a problem.");
                    show("\nyour:  " + your);
                    show("\nreal:  " + real);               

                }
            }
        }
        if (itReal.hasNext() != itYour.hasNext()) show("There's a problem.");
    }

    public static void main(String [] args)
    {
        MyList<Integer> your = new MyArrayList<Integer>();
        List<Integer> real = new ArrayList<Integer>(1);

        //your = new MyLinkedList<Integer>();

        show("demonstrate add::::::::::");
        for (int i = 0; i < 4; i++)
        {
            show("your:  " + your);
            //debug("real:  " + real);
            //Integer value = new Integer(random(100));
            //debug("add(" + i + ")");
            //real.add(i);
            your.add(i);
            System.out.println (your);
        }

        show("your list:    \t" + your);
        show("demonstrate add at index::::::::::");
        your.add(0, -10);
        show("add(0, -10):   \t"+ your);

        your.add(your.size()/2, -222);
        show("add(mid, -222):\t"+ your);

        your.add(your.size(), -1*your.size());
        show("add(siz, -siz):\t" + your);

        show("demonstrate remove at index::::::::::");
        //your.remove(your.size());
        //show("remov(siz):  \t" + your);

        your.remove(your.size()/2);
        show("remov(mid):  \t" + your);

        your.remove(0);
        show("remov(0):   \t" + your);

        show("demonstrate Iterator hasNext and next:::::::::");
        show("your:  " + your);
        Iterator<Integer> your_it = your.iterator();
        Integer yourVal;
        Integer value;
        int index=0;
        String s ="";
        while (your_it.hasNext())
        {
            yourVal = your_it.next();
            s += yourVal + ", ";
        }
        show("next gives:");
        show(s);
        show("your: "+ your);

        show ("\n More tests:::::::::::");
        your = new MyArrayList<Integer>();
        moreTests(real, your);
    }

}
