package stack;

public class SinglyLinkedStack<E> implements Stack<E>{ //LIFO Principle
	SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public SinglyLinkedStack(){}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public E pop(){ //removing 
		return list.removeFirst();
	}
	
	public void push(E e){ //adding
		 list.insertFirst(e);
	}
	
	public E top(){
		return list.first();
	}
	
	
	public static void main(String[] args){
		SinglyLinkedStack<String> LinkedStack = new SinglyLinkedStack<>();
		
		LinkedStack.push("testing adding 1");
		System.out.println(LinkedStack.top());
		LinkedStack.push("testing adding 2");
		System.out.println(LinkedStack.top());
		System.out.println(LinkedStack.size());
		LinkedStack.pop();
		System.out.println(LinkedStack.top());
		System.out.println(LinkedStack.size());
	}

}
