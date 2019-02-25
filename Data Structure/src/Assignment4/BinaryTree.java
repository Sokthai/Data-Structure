package Assignment4;
//Program: BinaryTree
//Written by: Sokthai Tang
//Program Description: This class provides the tool to manipulate the tree, such as adding, removing,  replaceElement etc...
//File name: BinaryTree.java
//File description: proper tree structure
//Challenges:
//Time Spent: 2hour
//Specified Output:                      <-- for client/tester class only, the output specified by the assignment
//--------------------         
//Actual Output:                      <-- for client/tester class only, copy & paste the actual output of your program
//--------------------  
//          Revision History
//Date:04/12/2016      				By:ST                  Created
//Date:04/14/2016                   By:ST                  Action: add assertion, precondition, and post condition


import java.util.Iterator;


public class BinaryTree <E> implements Iterable<E>{ 

    protected BTNode <E> root = new BTNode<>();  // starts out with just a root, which is external and empty
    protected int size = 1; // how many nodes are in the tree
	private String e = ""; //for the toStrign();
	private BTNode<E> nodeLoop ;
	
	private int child = 1;
	
	//return the size of the tree
    public int size() {
    	return size;
    }
    
    
    /**
     * replaceElement: this method will replace the element of the v Node with e
     * Precondition: ensure the node v is not null
     * Postcondition: setting the e to v
     * @param v , e
     */    
    protected void replaceElement(BTNode <E> v, E e)	throws BinaryTreeException {
    	assert ((v != null)): "replaceElement: Node can not be null";
    	v.setElement(e);	
    }
    
    /**
     * isRoot: check if the given Node v is root
     * Precondition: ensure the node v must not be null
     * Postcondition: return true is node v is root
     * @param v 
     */ 
    
  
    protected boolean isRoot(BTNode <E> v) throws BinaryTreeException{
    	assert (v != null) : "isRoot: Node can not be null";
    	return v.equals(root);
    }
    
    
    /**
     * isInternal: check if the given Node v is an internal node (has at least one child)
     * Precondition: ensure the node is not null
     * Postcondition: return true if the given node has at least one child
     * @param v 
     */ 
    
    protected boolean isInternal(BTNode<E>  v) throws BinaryTreeException {
    	assert (v != null): "isInternal: Node can not be null";
    	return ((v.leftChild() != null) || (v.rightChild() != null));
    }
    
    /**
     * isExternal: check if the given Node v is an External node (no child)
     * Precondition: ensure the node is not null
     * Postcondition: return true if the given node has no child
     * @param v 
     */ 
    
    protected boolean isExternal (BTNode<E>  v)throws BinaryTreeException {
    	assert (v != null): "isExternal: Node can not be null";  	
    	return ((v.leftChild() == null) && (v.rightChild() == null));
    }
    
    /**
     * isRightChild: check if the given Node v is the right child of its parent
     * Precondition: ensure the node is not null
     * Postcondition: return true if the node v is equal to the right child of its parent
     * @param v 
     */ 
 
    protected boolean isRightChild(BTNode<E> v) throws BinaryTreeException {
    	assert (v != null): "isRightChild: Node can not be null";
    	return v.parent().rightChild().equals(v);
    }
    
    /**
     * isLeftChild: check if the given Node v is the left child of its parent
     * Precondition: ensure the node is not null
     * Postcondition: return true if the node v is equal to the left child of it parent
     * @param v 
     */ 
 
    protected boolean isLeftChild(BTNode<E>  v) throws BinaryTreeException {
    	assert (v != null): "isLeftChild: Node can not be null";
    	return v.parent().leftChild().equals(v);
    }
    
    /**
     * swapElements: swapping the Element between the two given Nodes v, and x
     * Precondition: ensure the two given nodes v, and x are not null
     * Postcondition: swapping two nodes elements
     * @param v, x
     */ 
    protected void swapElements(BTNode<E>  v, BTNode<E>  x) throws BinaryTreeException {
    	assert ((v != null) || (x != null)): "swapElements: The nodes v, and x must not be null";
    	    	
    	E element = v.element();
    	v.setElement(x.element());
    	x.setElement(element);
    	
    }
    
    /**
     * sibling: checking the sibling of the given node v
     * Precondition: ensure the two given nodes v is not null
     * Postcondition: return the Node of the given node's sibling
     * @param v
     */
   
    protected BTNode<E>  sibling(BTNode<E>  v) throws BinaryTreeException{
    	assert (v != null): "sibling: Node can not be null";
    	if (v.parent() == null)
    		throw new BinaryTreeException("Sibling: root does not have sibling");
    	
    	if (v.parent().leftChild().equals(v))
    		return v.parent().rightChild();
    	else
    		return v.parent().leftChild();
    }
    
    /**
     * expandExternal: expand and create two empties nodes to the external node
     * Precondition: ensure the node v is not null
     * Postcondition: create two nodes and set their parent to the given node v
     * @param v
     */
    
    protected void expandExternal(BTNode<E>  v) throws BinaryTreeException {
    	assert (v != null) : "expandExternal: Node can not be null";
    	if (isInternal(v))
    		throw new BinaryTreeException("expandExceptional: Can not expand internal node");
    	
    	BTNode<E> leftNode = new BTNode<> (v, null, null, null);
    	BTNode<E> rightNode = new BTNode<> (v, null, null, null);
    	v.setLeftChild(leftNode);
    	v.setRightChild(rightNode);
    	size += 2;
    	
    }
    
    /**
     * expandExternal: removes the given external node (the parameter) AND its parent, 
     * 				   and fixes up links, i.e. it removes TWO nodes.
     * 				   so that the sibling of the given node becomes the child of its grandparent
     * Precondition: ensure the node v is not null
     * Postcondition: remove the given external node and its parent 
     * @param v
     */
   
    protected void removeAboveExternal(BTNode<E>  v) throws BinaryTreeException { 
    	assert (v != null) : "removeAboveExternal: Node can not be null";
    	if (isInternal(v))
    		throw new BinaryTreeException("RemoveAboveExternal: Can not remove internal node");
    	
    	BTNode<E> parent = v.parent();
    	BTNode<E> sibling = sibling(v);
    	if (isLeftChild(parent))
    		parent.parent().setLeftChild(sibling);
    	else
    		parent.parent().setRightChild(sibling);  
    	
    	sibling.setParent(parent.parent());
    	parent.setElement(null);
    	parent.setParent(null);
    	parent.setLeftChild(null);
    	parent.setRightChild(null);
    	size -= 2;
    }
    
    
    public Iterator<E> iterator(){
    	return new ElementClass();
    }
    
//=======================================================================================================================    
//=======================================================================================================================  
//=======================================================================================================================    
//======================================================================================================================= 
    //===========nested Element class=========================
    private class ElementClass implements Iterator<E>{ //iterate through proper tree
    	private boolean removable = false;
//    	private BTNode<E> nodeTemp;
    	
     
    	public boolean hasNext(){
    		
//    		if (nodeLoop.leftChild() != null){
//    			
//    			nodeTemp = nodeLoop.leftChild();
//    			removable = true;
//    			return true;
//    		}
//    			
//    		if (nodeLoop.rightChild() != null){
//    			
//    			nodeTemp = nodeLoop.rightChild();
//    			return true;
//    		}
//    		return false;	
    		nodeLoop = parentheticRepresentation(root);
//    		System.out.println("==> this is hasnext " + nodeLoop.element() + " " + child);
    		return (nodeLoop.leftChild() == null && nodeLoop.rightChild() == null);
    	}
    	
    	public E next(){
    		
    		
    		
    		return nodeLoop.element();
    	}
    	
    	public void remove(){
    		if (removable)
    			System.out.println("removing sth");
    	}
    }
    	
    //=============end nested class================================================================
    
    
    private BTNode<E> children(BTNode<E> v){
    	if (child == 1){
    		child = 2;
    		nodeLoop = v.leftChild();
    		
    	}else{
    		child = 1;
    		nodeLoop = v.rightChild();
    	}
    	return nodeLoop;
    }
    
    private BTNode<E> parentheticRepresentation(BTNode<E> v) {
    	 BTNode<E> nodeTemp ;
    	  
    	    Boolean firstTime = true;
    	    nodeLoop = children(root);
    	    
    	    if (firstTime) {
    	    	nodeTemp = parentheticRepresentation(nodeLoop.leftChild());  // the first child
    	    	firstTime = false;
    	    }else{
    	    	nodeTemp = parentheticRepresentation(nodeLoop.rightChild()); // subsequent child
    	    }
    	    
    	  
    	  return nodeTemp;
    	  }

    
  //=======================================================================================================================    
  //=======================================================================================================================  
  //=======================================================================================================================    
  //=======================================================================================================================     
    
    
    
    
    
    
    
     // expandExternal: This will return a string representing the Binary 
     //					Tree traversed in IN-ORDER traversal.
     //			        It calls the BTNode's toString() method implicitly.
    
    public String toString() { 
    	String s = "";
    	
    	
    	while (root.leftChild() == null && root.rightChild() == null){
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return inOrderTraversal(root); //traversal the entire tree.
    }
    
    /**
     * inOrderTraversal: traversal the tree recursively (from left to right)
     * @param root
     */
    
    private String inOrderTraversal(BTNode<E> root) throws BinaryTreeException{          
       	if (root != null){  
       		inOrderTraversal(root.leftChild());   
       		e += root.element() + " ";
       		inOrderTraversal(root.rightChild());  
       	}  
	  	  return e;
  	}
    
//  public String parentheticRepresentation(BinaryTree<E> T, BTNode<E> v) {
//	  String s = v.element().toString(); // main visit action
//	  
//	  if (isInternal(v)) {
//	    Boolean firstTime = true;
//	    
//  	    for (int i = 0; i <=1; i++){
//  	    	 if (firstTime) {
//     	    	  	s += " ( " + parentheticRepresentation(T, v.leftChild());  // the first child
//     	    	  	firstTime = false;
//     	      	}else {
//     	      		s += ", " + parentheticRepresentation(T, v.rightChild()); // subsequent child
//     	      		s += " )";
//     	      		}
//     	      	}// close parenthesis
//  	    }
//	  return s;
//  }
    
  public String parentheticRepresentation(BinaryTree<E> T, BTNode<E> v) {
	  String s = v.element().toString(); // main visit action
	  
	  if (isInternal(v)) {
	    Boolean firstTime = true;
	    
  	    for (int i = 0; i <=1; i++){
  	    	 if (firstTime) {
     	    	  	s +=  parentheticRepresentation(T, v.leftChild());  // the first child
     	    	  	firstTime = false;
     	      	}else {
     	      		s += parentheticRepresentation(T, v.rightChild()); // subsequent child
     	      	
     	      		}
     	      	}// close parenthesis
  	    }
	  return s;
  }
    //======================================================
    
   
  
  
 //===========================================================================================  


	public int depth(BTNode<E> node){ //given child
		if (node == root)
			return 0;
		else
			return 1 + depth(node.parent());
	}
	
	public int depthIteration(BTNode<E> node){ //given child
		int depth = 0;
//		System.out.println("ok in depth interation");
		while (node != root){
			if (node.parent() != null)
				depth++;	
			node = node.parent();
		}
		return depth;
	}
	
	public int height(BTNode<E> node){ //given parent
		int l = 0, r = 0;
		if (node.leftChild() != null)
			l = 1 + height(node.leftChild());
		if (node.rightChild() != null)
			r = 1 + height(node.rightChild());
			
		return Math.max(l, r);
		
	}
        


}














