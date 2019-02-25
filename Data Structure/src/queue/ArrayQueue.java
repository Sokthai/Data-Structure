package queue;

public class ArrayQueue<E> implements Queue<E> {
	private static final int CAPACITY = 1000;
	private E[] data ;
	private int f = 0, size = 0;
	
	
	public ArrayQueue(){
		this(CAPACITY);
	}
	
	public ArrayQueue(int capaticy){
		data = (E[]) new Object[capaticy];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
	//ADDING
	//it'll throw an IllegalStateException if try to add element to an full Array
	public void enqueue(E e) throws  IllegalStateException{
		if (size == data.length) throw new IllegalStateException("Queue is full");
		System.out.printf("f is before %s%n", f);
		int avail = (f + size) % data.length;
		System.out.printf("avail is before %s%n", avail);
		data[avail] = e;
		size++;	
	}
	
	public E first(){
		if (isEmpty()) return null;
		
		return data[f];
	}
	
	//REMOVING
	public E dequeue(){
		if (isEmpty()) return null;
		E answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		size--;
		return answer;
	}
	
	public int size(){
		return size;
	}
	
	
	public static void main(String[] args){
//		ArrayQueue<Integer> array = new ArrayQueue<> ();
//		array.enqueue(new Integer (30));
//		System.out.println(array.size());
		int i = 8, j = 10;
		System.out.println(j % i);
	}
}
