//package Assignment5;
//
//
////Written by: Margie Bleichman
////Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//// PriorityQueue is a Heap that stores objects in a certain order
//// This one will always maintain the maximum key in the root
////File name: PriorityQueue.java 
////File description: This is the Priority Queue class.  This Priority Queue is sorted with the MAX key in the root.
//// This means that when doing up heap or down heap bubbling, we must ensure that element in the parent is 
//// always greater than or equal to the element of each of its children.
//
////Java Files in this program:  
////Provided by professor: Emp, BTNode, BinaryTree, BinaryTreeException
////Written by student: Heap, PriorityQueue, testers
//
////Note the "extends Comparable".  This is so that two E's may be compared, using the compareTo() method.
////You can find the compareTo() method already written in the Emp class.
////Here is an example of code that uses this method appropriately (and it is an actual line from a solution.)
////       if (c.element().compareTo(p.element()) <= 0) break;  // if child is smaller, done
//
////Revision History:
////Date:                   By:               Action:
////---------------------------------------------------
////04/30/2016              mb              Created
//
//public class PriorityQueueForWenBin <E extends Comparable> extends HeapForWenBin <E > {
//// This is the only instance variable for this class: (do not add any others!
//protected int PQSize = 0;  // counts only internal nodes!
//
////(25 points)   
////Insert an item into the Priority Queue.
//// Pre-conditions:
//// Post-conditions:   
//public void insert(E item) throws BinaryTreeException{
// // asserts/exception handling
// // Use priority queue heap insertion algorithm studied in class.  
// // Add the item to the Heap: use only Heap's add() to do this part!  
// // (Hint: after the add() the new item is in the Last Node.)   
// // Then use Up-Heap Bubbling.  
//   add(item);        
//   BTNode<E> z=lastNode;  
//   BTNode<E> r;
//   while (! isRoot(z)) {     // up-heap bubbling
//       r = z.parent();
//       if (r.element().compareTo(z.element())>=0)
//           break;
//       swapElements(r,z);
//       z = r;
//   }        
//   PQSize++;
//}
//
////Peek at the next element that would be returned, but don't return it.
////This one is complete!  Don't change any of it!
//public E nextMax() {return  root.element();}
//
////(25 points)   
////Removes and returns the maximum item in the Priority Queue
//// Pre-conditions:
//// Post-conditions:  
//public E removeMax() throws PriorityQueueException, BinaryTreeException{
//  // asserts/exception handling
//   if(PQSize==0)
//       throw new PriorityQueueException("No one left to promote.");
//  // Use priority queue heap removal algorithm studied in class.        
//  
//  E maxItem=root.element();        
//  PQSize--;
//  
//  // Copy Last Node's element to the root.  
//  root.setElement(lastNode.element());       
//          
//  //lastNode.setElement(null);
//  // Call Heap's remove() -- use only Heap's remove() to do this part!
//   remove();        
//   BTNode<E> r = root;
//  // Then use Down-Heap Bubbling.
//  //if Node has 2 external children, done
//   //2.	a. if Node has 1 external child, use left child
////b. if Node has 2 internal children, use child   with smallest key
////c. compare Child key to Node Key
//   //3. if Child Key is greater or equal, done
//   //4.	Swap Node and Child Elements
//   //5. Using Child as current Node, loop to Step 1
//   
//   
//  
//   
//   
//   
//   while(PQSize>1)
//   {
//       BTNode<E> n;
//       if(isExternal(r.leftChild())&&isExternal(r.rightChild()))
//       {
//           break;
//       }
//       else if(isExternal(r.rightChild()))
//       {
//           n=r.leftChild();
//       }
//       else 
//       {
//           if(r.rightChild().element().compareTo(r.leftChild().element())>0)
//           {
//               n=r.rightChild();
//           }
//           else
//           {
//               n=r.leftChild();
//           }
//       }
//       if(n.element().compareTo(r.element())<=0)
//           break;
//       this.swapElements(r, n);        
//       r=n;
// 
//       
//       if (n.equals(lastNode) || sibling(n).equals(lastNode)) break;
//       
//       
//   }  // end while
//   
//   
//
//   if (PQSize == 2) 
//  	 lastNode = root.leftChild();
//   else if (PQSize == 0)
//  	 root = new BTNode<E> (null, null, null, null);
//
//   
//   
//  // Return the maximum item (which should have been stored earlier.) 
//  return maxItem;        
//}
//}
//
//
//
//
//
//
//
//
