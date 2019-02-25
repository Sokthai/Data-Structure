package deque;

import java.util.NoSuchElementException;

//Deque with DoublyLinkedList 04-03-16
public class doubleLinkedList<E> implements Deque<E>{
	
	public static class DLLNode<E>{
		private E element;
		private DLLNode<E> next;
		private DLLNode<E> previous;
		
		public DLLNode (E element, DLLNode<E> previous, DLLNode<E> next){
			this.element = element;
			this.previous = previous;
			this.next = next;
		}
		
		public void setElement(E element){
			this.element = element;
		}
		
		public E getElement(){
			return element;
		}
		
		public void setPrevious(DLLNode<E> previous){
			this.previous = previous;
		}
		
		public DLLNode<E> getPrevious(){
			return this.previous;
		}
		
		public void setNext(DLLNode<E> next){
			this.next = next;
		}
		
		public DLLNode<E> getNext(){
			return this.next;
		}
	} //END INNER CLASS
	
//==========END INNER CLASS=================
	
	private int size = 0;
	private DLLNode<E> header, trailer;
	
	
	
	public doubleLinkedList() {
		header = new DLLNode<E>(null, null, null);
		trailer = new DLLNode<E>(null, header, null);
		header.setNext(trailer);		
	} 
	
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public E first(){
		if (isEmpty()) return null;
		
		return header.getNext().getElement();
	}
	
	public E last(){
		if (isEmpty()) return null;
		
		return trailer.getPrevious().getElement();
	}
	
	public void addFirst(E e){
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e){
		addBetween(e, trailer.getPrevious(), trailer);
		
	}
	
	public E removeFirst()throws NoSuchElementException{
//		if (isEmpty()) return null;
		
		return remove(header.getNext());		
	}
	
	
	public E removeLast(){
		if (isEmpty()) return null;
		
		return remove(trailer.getPrevious());
	}
	
	private void addBetween(E e, DLLNode<E> predecessor, DLLNode<E> successor){
		DLLNode<E> newest = new DLLNode<E>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrevious(newest);
		size++;
		
	}
	
	private E remove(DLLNode<E> node){
		DLLNode<E> predecessor = node.getPrevious();
		DLLNode<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrevious(predecessor);
		size--;
		return node.getElement();
	}

}






















