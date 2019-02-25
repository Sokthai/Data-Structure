package Assignment5;

//============================================================================================================================
//Written by: SOKTHAI TANG
//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//File name: Heap.java
//File description: This builds the Heap based on the Linked Binary Tre
//Java Files in this program:  
//Provided by professor: Emp, BTNode, BinaryTree, BinaryTreeException
//Written by student: Heap, PriorityQueue, testers
//Revision History:
//Date:                   	By:               	Action:
//---------------------------------------------------
//05/10/2016              	ST              	Created
//05/10/2016				ST					fixing the add(), remove(), setInsertionNode(), and setLastnode()
//05/10/2016				ST					Adding Assertion and Exception
public class Heap<E> extends BinaryTree<E>{ 
 // These are the only instance variables for this class: (do not add any others!
 protected BTNode<E> insertionNode = root;
 protected BTNode<E> lastNode = null;
 
//(5 points)
//Adds an item to the heap at the insertion node. 
 // Pre-conditions: check if the item is not null
 // Post-conditions: add a new node to the existing tree
 public void add(E item) throws BinaryTreeException{  
 // asserts/exception handling
 // update lastNode (trivial -- don't call any method for this!)
 // put the element in
 // call  expandExternal()
 // update insertionNode:  you must call setInsertionNode() to do this!
	  	 	 
	 assert (item != null): "Item can not be null";
	 if (item == null) throw new BinaryTreeException("Can not add a null item");
	 
	 lastNode = insertionNode;	 
	 replaceElement(lastNode, item);
	 expandExternal(lastNode);
	 setInsertionNode();	 
	
		 
 }
 
 
//(5 points)   
//Removes two nodes (the last node and its right child)
 // Pre-conditions: check if the lastNode is null
 // Post-conditions:  remove two nodes from the tree  
 public void remove() throws BinaryTreeException{ 
 // asserts/exception handling
 // update insertionNode (trivial:  don't call any method for this!)
 // (Hint: we know the insertionNode with respect to the Last Node -- catch it now before we remove the Last Node!)
 // call removeAboveExternal()
 // update lastNode:  you must call setLastNode() to do this! 
	 
	 assert (root != null): "There is nothing to remove";
	 if (root == null) throw new BinaryTreeException("No item to be removed");
	 
	 insertionNode = lastNode;
	 removeAboveExternal(lastNode);
	 setLastNode();
 }
 
//(20 points) 
//Finds the new Insertion node starting at the Last Node, and sets the insertionNode instance variable.
 // Pre-conditions: Find the new insertion node
 // Post-conditions: set the new insertion node after insertion  
 private void setInsertionNode() throws BinaryTreeException{
 // asserts/exception handling 
 // Start at Last Node. 
 // Go up while not at a left child or at root.
 // Go to sibling or right child of the root.
 // Go down along left children until you reach an external node.  
 // That's the new Insertion Node.
	 
	 assert (insertionNode != null): "Can not set new insertion node";
	 if (insertionNode == null) throw new BinaryTreeException("Can not locate new insertion node");
	 
	 //Start at Last Node. if lastNode is leftChild, simply get its sibling
	 if (isLeftChild(lastNode)){insertionNode = sibling(lastNode); return;} //get its sibling	 
	 //Go up while not at a left child or at root.
	 while (isRightChild(insertionNode)){ insertionNode = insertionNode.parent(); if (isRoot(insertionNode))break;}
	 //Go to sibling or right child of the root.
	 if (!isRoot(insertionNode) && isLeftChild(insertionNode)){ insertionNode = sibling(insertionNode);}
	 //Go down along left children until you reach an external node.  
	 while (isInternal(insertionNode)){insertionNode = insertionNode.leftChild();}
 }
      
//(20 points)
//Finds the new Last Node starting at the Insertion Node, and sets the lastNode instance variable.
 // Pre-conditions: Find the new last node
 // Post-conditions:  sets new lastNode instance variable. 
 private  void setLastNode() throws BinaryTreeException{ 
 // asserts/exception handling
 // Start at Insertion Node.  
 // Go up while not at a right child or at root.
 // Go to sibling or left child of the root.
 // Go down along right children until you reach an external node.  
 // Its parent is the new Last Node.
	 
	 assert(lastNode != null): "Can not set new last node";
	 if (lastNode == null) throw new BinaryTreeException("Can not locate new last node");
	 
	 
	 //Start at Insertion Node. if insertionNode is the right, simply set to left
	 if (isRightChild(insertionNode)){ lastNode = sibling(insertionNode); return;}
	//Go up while not at a right child or at root.
	 while(isLeftChild(lastNode)){ lastNode = lastNode.parent(); if (isRoot(lastNode))break;}	
	 //Go to sibling or left child of the root.
	 if (!isRoot(lastNode) && isRightChild(lastNode)) lastNode = sibling(lastNode);
	//Go down along right children until you reach an external node.  
	 while (isInternal(lastNode)) lastNode = lastNode.rightChild();	
	 lastNode = lastNode.parent(); //its parent is the new last node
	 
 } 
 
 
}


