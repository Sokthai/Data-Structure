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
		
		public Node next() {
			return this.next;
		}
		
		public void setNode(Node next) {
			this.next = next;
		}
	}
	
	
	
	
	private Node head;
	private int size;
	
	public ScHashLinkList() {
		this.head = null;
		size = 0;
	}
	
	
	private int size() {
		return this.size;
	}
	
	public void push (Entry<K, V> entry) {
		if (head == null) {
			head = new Node<K, V>(entry, null);
		}else {
			Node<K, V> temp = head;
			while(head.next != null) {
				head = head.next;
			}
			head.next.setNode(new Node<K, V>(entry, null));
			head = temp;
		}
		this.size++;
	}
	
	public void pop(Entry<K, V> entry) {
		
	}
}
