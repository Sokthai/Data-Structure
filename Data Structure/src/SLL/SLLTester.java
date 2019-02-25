package SLL;

public class SLLTester {

	public static void main(String[] args){
		Node node = new Node(new Integer(10));
		Node node2 = new Node(new String("second"));
		node.setNext(node2);
		SinglyLinkedListImp sll = new SinglyLinkedListImp();
		
		sll.insertFirst(node2);
		sll.insertFirst(node);
//		sll.swapElements(node, node2);
		sll.insertAfter(node, new String("after"));
		
		
		
		
//		sll.replaceElements(node, new String("Secondesfd"));
		
//		System.out.println(sll.first().element());
		sll.display();
		
//		
		
	}
	
}
