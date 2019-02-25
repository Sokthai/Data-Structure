package Assignment5;
//===================================================================
//Written by: SOKTHAI TANG
//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//   PriorityQueue is a Heap that stores objects in a certain order
//   This one will always maintain the maximum key in the root
//File name: PriorityQueue.java 
//File description: This is the Priority Queue class.  This Priority Queue is sorted with the MAX key in the root.
//   This means that when doing up heap or down heap bubbling, we must ensure that element in the parent is 
//   always greater than or equal to the element of each of its children.

//Java Files in this program:  
//Provided by professor: Emp, BTNode, BinaryTree, BinaryTreeException
//Written by student: Heap, PriorityQueue, testers

//Note the "extends Comparable".  This is so that two E's may be compared, using the compareTo() method.
//You can find the compareTo() method already written in the Emp class.
//Here is an example of code that uses this method appropriately (and it is an actual line from a solution.)
//         if (c.element().compareTo(p.element()) <= 0) break;  // if child is smaller, done

//Revision History:
//Date:                   	By:               	Action:
//---------------------------------------------------
//05/10/2016              	ST              	Created
//05/10/2016				ST					Adding insert(), removeMax()
//05/10/2016				ST					Fixing the a bug in the Down-heap Bubbling that keep deleting the element in the root
//05/10/2016				ST					Adding Assertion and Exception


//====================================Comparable<Object>
public class PriorityQueue <E extends Comparable> extends Heap <E > {
	 // This is the only instance variable for this class: (do not add any others!
	 protected int PQSize = 0;  // counts only internal nodes!
	 
	 //(25 points)   
	 //Insert an item into the Priority Queue.
	 // Pre-conditions: ensure the item is not null
	 // Post-conditions: insertion a new item into the queue
	 public void insert(E item) throws BinaryTreeException{
	 // asserts/exception handling
	 // Use priority queue heap insertion algorithm studied in class.  
	 // Add the item to the Heap: use only Heap's add() to do this part!  
	 // (Hint: after the add(), the new item is in the Last Node.)   
	 // Then use Up-Heap Bubbling.   
		 
		 assert (item != null): "Can not add a null item";
		 if (item == null) throw new BinaryTreeException("Item can not be null");	 
		 
		 add(item);
		 BTNode<E> temp = lastNode;
		 //Up-Heap Bubbling
		 while(!isRoot(temp)){		 			 
			 if (temp.element().compareTo(temp.parent().element()) < 0) break; //if greater than it's parent
			 swapElements(temp, temp.parent()); temp = temp.parent();
			 
		 }		 
		 PQSize++;	 
	 }
	 
	//Peek at the next element that would be returned, but don't return it.
	// This one is complete!  Don't change any of it!
	public E nextMax() {
		return  root.element();
	}
	
	
	 //(25 points)   
	 //Removes and returns the maximum item in the Priority Queue
	 // Pre-conditions: ensure the queue is not empty
	 // Post-conditions:  return the Maximum item in the tree
	 public E removeMax() throws PriorityQueueException, BinaryTreeException{
	 // asserts/exception handling
	 // Use priority queue heap removal algorithm studied in class. 
	 // Copy Last Node's element to the root.  
	 // Call Heap's remove() -- use only Heap's remove() to do this part!
	 // Then use Down-Heap Bubbling.
	 // Return the maximum item (which should have been stored earlier.) 
		 
		 assert (root != null): "No item to be removed";
		 if (PQSize <= 0) throw new BinaryTreeException("No one left to promote.");
		 
		 E max = root.element(); root.setElement(lastNode.element()); 
		 BTNode<E> parent = root, child = root.leftChild(); 
		 remove();	 
		 //Down-Heap Bubbling
		 while(isInternal(parent)){	 
			 if (PQSize == 2) break; //if there are only 2 nodes left, no Down-Heap is needed
			 if (PQSize == 1){ root = new BTNode<>(null, null,  null, null);insertionNode = root; break;} // if one node left, reset root 
			 if (sibling(parent.leftChild()).element() != null)  //get the larger child's element (heap property)				
				 child = (parent.leftChild().element().compareTo(parent.rightChild().element()) > 0)? parent.leftChild() : parent.rightChild(); //getting the largest child of its parent			 
			 if (parent.element().compareTo(child.element()) < 0){
				 swapElements(parent, child); parent = child;				
			 }else{break;}			 
			 if (parent.equals(lastNode) || sibling(parent).equals(lastNode)) break;
		 }
		 PQSize--;
		 return max;
	 }		 
}

