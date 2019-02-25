package tree;
import java.util.Iterator;

//import positionalListWithDoublyLinkedListStyle.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	//=========Nested Node class===================
	protected static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent, left, right;
		
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		//accessor methods
		public E getElement(){
			return element;
		}
		
		public Node<E> getParent(){
			return parent;
		}
		
		public Node<E> getLeft(){
			return left;
		}
		
		public Node<E> getRight(){
			return right;
		}
		
		public void setElement(E e){
			element = e;
		}
		
		public void setParent(Node<E> p){
			parent = p;
		}
		
		public void setLeft(Node<E> leftChild){
			left = leftChild;
		}
		
		public void setRight(Node<E> rightChild){
			right = rightChild;
		}
	}
	//=========End Node Class================
	
	
	//Factory function to create a new node storing element
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	
	//empty constructor
	public LinkedBinaryTree(){}
	
	
	//validate the position and returns it as a node
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p;
		if (node.getParent() == node)//our convention for defunct code
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}
	
	public int size(){
		return size;
	}
	
	public Position<E> root(){ //test this one, and see what is Position<E> type it is	 
		return  root;
	}
	
	
	public Position<E> parent(Position<E> p) throws  IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getRight();
	}
	
	public Position<E> addRoot(E e)throws IllegalStateException{
		if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;	
	}
	
	//create a new left child at Position p (so p becomes the parent of the element)
	public Position<E> addLeft(Position<E> p, E e)throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}
	
	//create a new right child at Position p (so p becomes the parent of the element)
	public Position<E> addRight(Position<E> p, E e)throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if (parent.getRight() != null)
			throw new IllegalArgumentException("p already has a right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}
	
	//replace the element at Position p with e and return the replaced element
	public E set(Position<E> p, E e)throws IllegalArgumentException{
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	
	//Attach tree t1 and t2 as left and right subtree of external p
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2)throws IllegalArgumentException{
		Node<E> node = validate(p);
		if (isInternal(p))
			throw new IllegalArgumentException("p must be a leaf");
		size += t1.size() + t2.size(); //add the total size of left and right child to the current size
		
		if(!t1.isEmpty()){ //t1 is the left child
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		
		if (!t2.isEmpty()){ //t2 is the right child
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	//remove the node at Position p and replace it with it child ,if any
	public E remvoe(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if (numChildren(p) == 2)
			throw new IllegalArgumentException("p has two children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null)
			child.setParent(node.getParent());//child's grandparent becomes its parent
		if (node == root){ //because the "node" need to be removed
			root = child; //so the child becomes root
		}else{
			Node<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
			
	}
	
	
//	//==============nested Position class
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
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
	
	
	public Iterator<E> iterator(){
		return new ElementIterator();
//		return createNode(root.getElement(), parent(), left, right);
	}
	
	
	public Iterable<Position<E>> positions(){
		return new LinkedBinaryTree<>();
	}
	
	
	//public void inOrder(TreeNode root) {  
	//	  if(root !=  null) {  
	//	   inOrder(root.left);  
	//	   //Visit the node by Printing the node data    
	//	   System.out.printf("%d ",root.data);  
	//	   inOrder(root.right);  
	//	  }  
	//	 }  

	
	
	
	
	public static void main(String[] args){
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
		System.out.println(t.size());
		
		
		for (Integer i : t){
			System.out.println(i);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
