package SLL; //Feb, 28, 2016

public class SinglyLinkedListImp<E> {

	private Node<E> head;
    private int size;

    public SinglyLinkedListImp() {
        this.head = null;
        this.size = 0;
    }

    public Node<E> first() {
        return head;
    }

    public Node<E> last() {
        Node<E> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public boolean isFirst(Node<E> n) {
        return (head == n);
    }

    public boolean isLast(Node<E> n) {
        return (n.getNext() == null);
    }

    public Node<E> before(Node<E> n) {
        Node<E> current = head;
        while (current.getNext() != n) {
            current = current.getNext();
        }
        return current;
    }

    public Node<E> after(Node<E> n) {
        return n.getNext();
    }

    public Node<E> replaceElements(Node<E> n, E element) {
    	Node<E> currentHead = head;
    	System.out.println(head.element());
    	System.out.println(n.element());
    	
    	if (head.element() instanceof Node)// && n.element() instanceof Integer)
    		System.out.println("ok the same");
//    	
//    	System.out.printf("repalce %s %n head %s %n", n.element(), currentHead.element());
//    		while(currentHead.element() != n.element()){
//    			System.out.println("in");
//    			if (currentHead.getNext() == null)
//    				break;
//    				
//    				currentHead = currentHead.getNext();
//    			
//    			
//    		}
//    		currentHead.setElement(element);
    	return currentHead;
    	
    }
    
    
//    public Node<E> replaceElements(Node<E> n, E element) {
//        Node<E> current = head;
//        Node<E> previous = null;
//        while (current != n) {
//            previous = current;
//            current = current.getNext();
//        }
//        Node<E> newLink = new Node<E>(current.getNext(), element);
//        previous.setNext(newLink);
//        return current;
//    }

    public void swapElements(Node<E> n, Node<E> k) {
        E tmp = n.element();
        n.setElement(k.element());
        k.setElement(tmp);
    }

    public void insertFirst(E element) {
        head = new Node<E>(head, element);
        size++;
    }

    public void insertLast(E element) {
        if (head == null) {
            head = new Node<E>(head, element);
        } else {
            Node<E> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<E>(null, element));
        }
        size++;
    }

    public void insertBefore(Node<E> n, E element) {
        Node<E> current = head;
        Node<E> previous = null;
        while (current.getNext() != n) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(n);
    }

    public void insertAfter(Node<E> n, E element) {
//        Node<E> current = head;
//        while (current != n) {
//        	if (current.getNext() == null)
//        		break;
//        	
//            current = current.getNext();
//        }
//        current.setNext(n);
    	
    	
    	
    }

    public void remove(Node<E> n) {
        Node<E> current = head;
        Node<E> previous = null;
        while (current != n) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(current.getNext());
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list.");
        } else {
            Node<E> current = head;
            while (current != null) {
                System.out.println(current.toString());
                current = current.getNext();
            }
        }
    }

}
