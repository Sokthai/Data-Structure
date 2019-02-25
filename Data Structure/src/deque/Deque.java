package deque;

import java.util.NoSuchElementException;

public interface Deque<E> {
	public int size() throws  ArithmeticException;
	public boolean isEmpty();
	public E first();
	public E last();
	public void addFirst(E e);
	public void addLast(E e);
	public E removeFirst() throws NoSuchElementException;
	public E removeLast()throws NoSuchElementException;
	
}
