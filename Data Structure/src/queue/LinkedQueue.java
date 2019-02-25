package queue;

public class LinkedQueue<E> implements Queue<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	public LinkedQueue(){}
	public int size() { return list.size(); }
	public boolean isEmpty(){ return list.isEmpty(); }
	//add
	public void enqueue(E element) { 
		list.insertLast(element);
	}
	public E first() {return list.first();}
	
	
	//remove
	public E dequeue(){return list.removeFirst();}
	
	
	
	
	
	
	public static void main(String[] args){
		LinkedQueue<String> linked = new LinkedQueue<>();
		System.out.println(linked.size());
		linked.enqueue("testing the linked queue");
		System.out.println(linked.size());
		System.out.println(linked.first());
	}
	
	
}
