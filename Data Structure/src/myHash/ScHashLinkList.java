package myHash;

public class ScHashLinkList<K, V> {//with singlylink list
	
	
	
	
	private static class Node<K, V>{
		
		private Entry<K, V> entry;
		private Node next;
		
		public Node(Entry<K, V> value, Node next) {
			this.entry = value;
			this.next = next;
		}
		
		public Entry<K, V> getEntry() {
			return this.entry;
		}
		
		public void setEntry(Entry<K, V> entry) {
			this.entry = entry;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node<K, V> next) {
			this.next = next;
		}
	}
	
	
	
	
	private Node<K, V> head;
	private int size;
	
	public ScHashLinkList() {
		this.head = null;
		this.size = 0;
	}
	
	public ScHashLinkList(Entry<K, V> entry) {
		this.head = null;
		this.addFrist(entry);
	}
	
	
	
	public int size() {
		return this.size;
	}
	
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public Entry<K, V> get(K key){
		
		Node<K, V> temp = this.head;
		
		while(temp != null) {
			if (temp.getEntry().getKey().equals(key)) {
				return temp.getEntry();
			}
			temp = temp.next;
		}
		
		return null;
	}
	
	
	
	
	public void push (Entry<K, V> entry) {
		if (head == null) {
			head = new Node<K, V>(entry, null);
		}else {
			Node<K, V> temp = head;
			while(head.next != null) {
				head = head.next;
			}
			head.next.setNext(new Node<K, V>(entry, null));
			head = temp;
		}
		this.size++;
	}
	
	public Entry<K, V> addFrist(Entry<K, V> entry){
		Node<K, V> newHead = new Node<K, V>(entry, this.head);
		this.head = newHead;
		this.size++;
		return entry;
	}
	
	
	
	public V pop(K key) {
		V result = null;
		result = this.removeHead(key);

		if (result != null) {
			return result;
		}
		
		Node<K, V> temp = this.head;
//		System.out.println("is null? fdsf " + temp.getEntry().getKey());
		
		
		while (temp != null) {
			if (temp.next.getEntry().getKey().equals(key)) {
				result = (V) temp.next.getEntry().getValue();
				temp.next = temp.next.next;
				this.size--;
				return result;
			}
			temp = (Node<K, V>) temp.next;
			
		}
		return null;
	}
	
	
	private V removeHead(K key) {
		Entry<K, V> entry = this.head.getEntry();
		
		if (this.head != null && this.head.getEntry().getKey().equals(key)) {
			this.head = this.head.getNext();
			return entry.getValue();
		}
		return null;
	}
	
	
	public V set(K key, V value) {
		Node<K, V> temp = this.head;
		while(temp != null) {
			if (temp.getEntry().getKey().equals(key)) {
				temp.getEntry().setValue(value);
				return value;
			}
			temp = temp.next;
		}
		return null;
	}
	
	
	public Entry<K, V> getHead(){
		return this.head.getEntry();
	}
}
