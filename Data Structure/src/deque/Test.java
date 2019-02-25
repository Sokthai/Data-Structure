package deque;

import java.util.NoSuchElementException;

public class Test {
	public static void main (String[] args){
		doubleLinkedList<Integer> node = new doubleLinkedList<>();
		Integer first = new Integer(10);
		Integer second = new Integer(20);
		
		try{
			node.addFirst(first);
			node.addLast(second);
			
			System.out.println(node.first());
			System.out.println(node.size());
			
			node.removeFirst();
			System.out.println(node.first());
			node.removeFirst();
			System.out.println(node.first());
			node.removeFirst();
		}catch (NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}
}
