package list;

import java.util.Iterator;

//import java.util.Iterator;
public interface List<E> extends Iterable<E>{
	int size();
	boolean isEmpty();
	E get(int i) throws IndexOutOfBoundsException; // return e at index i
	E set(int i , E e) throws IndexOutOfBoundsException; // set new value e at index i
	void add(int i , E e) throws IndexOutOfBoundsException; //insert e at index i. require shifting
	E remove(int i ) throws IndexOutOfBoundsException; //remove at index i. require shifting
	Iterator<E> iterator();
}
