package queue;

/**
 * 03/07/2016
 * @author Allen
 * Defining traditional Queue ADT (Abstract Data Type)
 * The Queue principle is First-in-First-Out (FIFO)
 * @param <E>
 */
public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E first();
	E dequeue();
	
}
