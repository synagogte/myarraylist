import java.util.Iterator;

/*
 * DO NOT MODIFY THIS INTERFACE.
 * YOU CANNOT SUCCESFULLY COMPLETE THE LAB OR FUTURE LABS IF YOU CHANGE ANYTHING
 * IN THIS INTERFACE
 * There are no user serviceable parts inside.
 * Altering this class in any way will void your warranty.
 * @author Mr. Page
 * @version 092713
 */
public interface MyListIterator<E> extends MyIterator<E>
{
    
    void add(E obj);
    void set(E obj);
   
    
}