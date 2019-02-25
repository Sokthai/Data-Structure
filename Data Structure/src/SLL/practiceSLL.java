package SLL;

public class practiceSLL {

	private class Node<E>{
		private Node<E> next;
		private E element;
		
		public Node(E e, Node<E> next){
			this.element = e;
			this.next = next;
		}
		
		public E getElement(){
			return this.element;
		}
		
		public void setElement(E e){
			this.element = e;
		}
		
		public Node<E> getNext(){
			return this.next;
		}
		
		public void setNext(Node<E> next){
			this.next = next;
		}
		
		public String toString(){
			return "Element : " + element;
		}
	}
	
	
	
	public class SLL<E>{
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size = 0 ;
		
		private Node<E> first(){
			return head;
		}
		
		private Node<E> last(){
			return tail;
		}
		
		private boolean isFirst(Node<E> p){
			return p == head;
		}
		
		private boolean isLast(Node<E> p){
			return p == tail;
		}
		
		
		private void addFirst(E e){
			Node<E> newHead = new Node<>(e, head);
			head = newHead;
			size++;
		}
		
		private void addLast(E e){
			Node<E> newTail = new Node<> (e, null);
			tail = newTail;
			size++;
		}
		
		private int getSize(){
			return this.size;
		}
		
		private Node<E> before(Node<E> p){// throws NullPointerException{ //return Node before P 
			Node<E> currentHead = head;
			Node<E> beforeP = null;
			
//			while (currentHead != p){
//				if (currentHead.getNext() == null) //when reach the last node, break it or it throws NullPointerException
//					break; 			
//				beforeP = currentHead;   //store the previous node before the right one is reached
//				currentHead = currentHead.getNext();
//			}			
			
//			return beforeP;
			
			 Node<E> current = head;
		        while (current.getNext() != p) {
		        	if (currentHead.getNext() == null) //when reach the last node, break it or it throws NullPointerException
						break; 
		            current = current.getNext();
		        }
		        return current;		
			
		}
		
		
		private Node<E> after(Node<E> p){ //return Node after p
			return p.getNext();
		}
		
		
		
		
		private void replace(Node<E> p, E e){ //replace Element only . not the whole Node
			Node<E> currentHead = head;
			boolean y = true; //special case: if p doesn't exist in the entire node
			
			while (currentHead != p){
				if (currentHead.getNext() == null){
					if (currentHead != p)
						y = false;
					break;
				}
				
				currentHead = currentHead.getNext();
			}
				
			if (y) currentHead.setElement(e);
			
			
		}
		
		private void swapElement(Node<E> p, Node<E> q){
			E temp = p.element;
			p.setElement(q.getElement());
			q.setElement(temp);
		}
	
		
		private void addBefore(Node<E> p, E e){
			Node<E> currentHead = head;
			//Node<E> beforeP = null;
			Node<E> node = new Node<> (e, p);
			
			while(currentHead.getNext() != p){		
				//beforeP = currentHead;
				currentHead = currentHead.getNext();
			}
			//beforeP.setNext(node);
			currentHead.setNext(node);
			
		}
		
		private void remove(Node<E> p){
			Node<E> currentHead = head;
			Node<E> beforeP = null;
			
			while(currentHead != p){
				beforeP = currentHead;
				currentHead = currentHead.getNext();
			}
			beforeP.setNext(currentHead.getNext());
			size--;
			
		}
		
		private void addAfter(Node<E> p, E e){
			Node<E> currentHead  = head;
			Node<E> node = new Node<>(e, p.getNext());
			
			while (currentHead != p){
				currentHead = currentHead.getNext();
			}
			currentHead.setNext(node);
			
			
			
		}
		
		
	}
	

	public static void main(String[] args) {
		

	}

}
