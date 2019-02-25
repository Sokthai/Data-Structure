package priorityQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * page 275 (Data structure eBook)
 * March-16-2016
 * @author Allen
 *
 * @param <E>
 * 
 */
public class LinkedPostionalList<E> implements PositionalList<E>, Iterable<E>{
	
	
	
	/**
	 * Position returns Object reference
	 * Position : Because the position is return the reference of the object, meaning the 
	 * when the object is returned, we have the whole object reference like method and variable etc...
	 * unlike Deque, it returns element. 
	 * @author Allen
	 *
	 * @param <E>
	 */
	
	//===================nested class======================
	private static class Node<E> implements Position<E>{ 
		private E element;
		private Node<E> prev, next;
		
		public Node(E e, Node<E> p, Node<E> n){
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement() throws IllegalStateException{
			if (next == null)
				throw new IllegalStateException("Position no longer valid");
			return element;
		}
		
		public Node<E> getPrev(){
			return prev;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setElement(E e){
			element = e;
		}
		
		public void setPrev(Node<E> p){
			prev = p;
		}
		
		public void setNext(Node<E> n){
			next = n;
		}
	}
	//===============ended nested class================
	
	
	
	//implement Doubly Linked List Style with Positional List
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public LinkedPostionalList(){
		header = new Node<>(null, null, null); //because it is based on Doubly Linked list, so it has previous and next 
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	private Node<E> validate(Position<E> p)throws IllegalArgumentException{
		if (!(p instanceof Node)) 
			throw new IllegalArgumentException("Invalide p");
		Node<E> node = (Node<E>) p; //safe cast
		if (node.getNext() == null) //convention for defunct node. because the header and the trailer are null, 
									//so, if it is trailer or header, it must be not exist in the list
			throw new IllegalArgumentException("p is no longer in the list");
		return node;
	}
	
	
	private Position<E> position(Node<E> node){
		if (node == header || node == trailer) //because in Doubly linked list, header and trailer have null value
			return null;
		return node;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public Position<E> first(){
		return position(header.getNext());
	}
	
	public Position<E> last(){
		return position(trailer.getNext());
	}
	
	public Position<E> before(Position<E> p)throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	
	public Position<E> after(Position<E> p)throws IllegalArgumentException{
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
	
	public Position<E> addFirst(E e){
		return addBetween(e, header, header.getNext());
	}
	
	public Position<E> addLast(E e){
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	public Position<E> addBefore(Position<E> p, E e)throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	public Position<E> addAfter(Position<E> p, E e)throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
	
	public E set(Position<E> p, E e)throws IllegalArgumentException{
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
	public E remove(Position<E> p)throws IllegalArgumentException{
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	
//=======================================================================================================
	
	//============nested class for Iterator====================
	private class PositionIterator implements Iterator<Position<E>>{
		private Position<E> cursor = first();
		
		private Position<E> recent = null;
		
		public boolean hasNext(){
			return cursor != null;
		}
		
		public Position<E> next() throws NoSuchElementException{
			if (cursor == null) throw new NoSuchElementException("nothing left");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		public void remove()throws IllegalStateException{
			if (recent == null) throw new IllegalStateException("nothing to remove");
			LinkedPostionalList.this.remove(recent); //call the remove method in the LinkedPositionalList to remove the recent element
			recent = null;
		}
				
	}//=================end nested class================================
	
	//==================nested Position class====================================
	private class PositionIterable implements Iterable<Position<E>>{
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}
	//==================end nested class================================
	
	
	//returns an iterable representation of the list's position
	public Iterable<Position<E>> positions(){
		return new PositionIterable(); //create a new instace of the inner class
	}
	
	//==================nested element class===================================
	//This class adapts the iterator producted by position() to return elements;
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = new PositionIterator();
		public boolean hasNext(){
			return posIterator.hasNext();
		}
		public E next(){
			return posIterator.next().getElement();
		}
		public void remove(){
			posIterator.remove();
		}
	}
	
	
	
	//while in forEach loop, it create ElementIterator class
	//the ElementIterator class will instantiate PositionIterator class and call it
	//the PositionIterator will execute the hasNext() and next() method
	public Iterator<E> iterator(){ 
		return new ElementIterator();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		LinkedPostionalList<Integer> pos = new LinkedPostionalList<>();
		
		
		
		
		
		
		
		p.println(pos.size());
		pos.addFirst(new Integer(1));
		Position<Integer> node ; //the Position type has only the getElement();
		node = pos.first();
		p.println(node.getElement());
		pos.addFirst(new Integer(77));
		node =  pos.first();
		p.println(node.getElement());
		
		
		
		pos.addFirst(new Integer (111));
		pos.addFirst(new Integer (222));
		pos.addFirst(new Integer (333));
		pos.addFirst(new Integer (444));
		pos.addFirst(new Integer (555));
		pos.addFirst(new Integer (666));
		pos.addFirst(new Integer (777));
		pos.addFirst(new Integer (888));
		pos.addFirst(new Integer (999));
		
		pos.remove(node);
		
		
//		Position<Integer> p;
//		Iterator<Position<Integer>> t =  pos.positions();
		
		
		for(Integer i : pos){
			p.println(i);
		
		}
		
		
//		System.out.println("ok");
	}
	
	
	
	
	
	
	
	
	
	
}
