package priorityQueue;


/**
 * page 275 (Data structure eBook)
 * March-16-2016
 * @author Allen
 *
 * @param <E>
 */
public interface PositionalList<E> {
	int size();
	boolean isEmpty();
	Position<E> first();
	Position<E> last();
	Position<E> before(Position<E> p)throws IllegalArgumentException;
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	Position<E> addFirst(E e);
	Position<E> addLast(E e);
	Position<E> addBefore(Position<E> p, E e)throws IllegalArgumentException;
	Position<E> addAfter(Position<E> p, E e)throws IllegalArgumentException;
	E set(Position<E> p, E e)throws IllegalArgumentException;
	Iterable<Position<E>> positions();
	
	//remove the element stored at Position p and return it
	E remove(Position<E> p) throws IllegalArgumentException;
//	Object positions();
}

