//package Assignment5;
//
//
//
////Written by: Margie Bleichman
////Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
////File name: Heap.java
////File description: This builds the Heap based on the Linked Binary Tre
////Java Files in this program:  
////Provided by professor: Emp, BTNode, BinaryTree, BinaryTreeException
////Written by student: Heap, PriorityQueue, testers
////Revision History:
////Date:                   By:               Action:
////---------------------------------------------------
////04/30/2016              mb              Created
//public class HeapForWenBin<E> extends BinaryTree<E> { 
////These are the only instance variables for this class: (do not add any others!
//protected BTNode<E> insertionNode = root;
//protected BTNode<E> lastNode = null;
//
////(5 points)
////Adds an item to the heap at the insertion node. 
////Pre-conditions:
////Post-conditions:
//public void add(E item) throws BinaryTreeException{  
// // asserts/exception handling
// // update lastNode (trivial -- don't call any method for this!)
// lastNode=insertionNode;
// insertionNode.setElement(item);        
// // put the element in
// // call  expandExternal()
// expandExternal(insertionNode);
// // update insertionNode:  you must call setInsertionNode() to do this!                
// setInsertionNode();
//}
//
////(5 points)   
////Removes two nodes (the last node and its right child)
////Pre-conditions:
////Post-conditions:    
//public void remove() throws BinaryTreeException{ 
// // asserts/exception handling
// // update insertionNode (trivial:  don't call any method for this!)
// // (Hint: we know the insertionNode with respect to the Last Node -- catch
// //it now before we remove the Last Node!)
// insertionNode=lastNode;                
// // call removeAboveExternal()                                     
//// if(this.isExternal(lastNode.leftChild())&&this.isExternal(lastNode.rightChild()))
//// {
////     lastNode.setLeftChild(null);
////     lastNode.setRightChild(null);
////     lastNode.setElement(null);           
////
//// }
//removeAboveExternal(lastNode);
// // update lastNode:  you must call setLastNode() to do this!         
// setLastNode();
//}
//
////(20 points) 
////Finds the new Insertion node starting at the Last Node, and sets the insertionNode instance variable.
////Pre-conditions:
////Post-conditions:   
//private void setInsertionNode() throws BinaryTreeException {
//// asserts/exception handling 
// // Start at Last Node. 
// // Go up while not at a left child or at root.        
//// BTNode<E> z = lastNode;
//// if(isLeftChild(z))
//// {
////      z = sibling(z);
//// }
//// else
//// {
////     //If not left child, go up until you reach a left child or the root
////     while (! isRoot(z) && (! isLeftChild(z)))                
////         z =z.parent();                                   
////     if(isLeftChild(z))
////     {
////         z=z.parent().rightChild();                
////     }
//// }
//// // Go down along left children until you reach an external node.  
//// // That's the new Insertion Node.
//// while (! isExternal(z))
////    z = z.leftChild();
//// insertionNode=z;
//
//
//if(isLeftChild(lastNode))
// {
//      insertionNode= sibling(lastNode);
// }
// else
// {
//     //If not left child, go up until you reach a left child or the root
//     while (! isRoot(insertionNode) && (! isLeftChild(insertionNode)))                
//         insertionNode =insertionNode.parent();      
//     
//     if(isLeftChild(insertionNode))
//     {
//         insertionNode=insertionNode.parent().rightChild();                
//     }
// }
// // Go down along left children until you reach an external node.  
// // That's the new Insertion Node.
// while (! isExternal(insertionNode))
//    insertionNode = insertionNode.leftChild();
//
//}
//  
////(20 points)
////Finds the new Last Node starting at the Insertion Node, and sets the lastNode instance variable.
////Pre-conditions:
////Post-conditions:   
//private  void setLastNode() throws BinaryTreeException{ 
// // asserts/exception handling
// // Start at Insertion Node.  
//// BTNode<E> z = insertionNode;
//// //If right child, go to sibling
//// if(isRightChild(z))
//// {
////     z = sibling(z);
//// }
//// else
//// {
////     //If not right child, go up until you reach a right child or the root        
////     while (! isRoot(z) && (! isRightChild(z)))
////         z =z.parent();     
////     if(isRightChild(z))
////     {
////         z=z.parent().leftChild();                
////     }
//// }        
//// // Go down along right children until you reach an external node.  
//// // Its parent is the new Last Node.
//// while (! isExternal(z))
////    z = z.rightChild();        
//// lastNode=z.parent();
//
//
////If right child, go to sibling
// if(isRightChild(insertionNode))
// {
//     lastNode = sibling(insertionNode);
// }
// else
// {
//     //If not right child, go up until you reach a right child or the root        
//     while (! isRoot(lastNode) && (! isRightChild(lastNode)))
//         lastNode =lastNode.parent();     
//     if(isRightChild(lastNode))
//     {
//         lastNode=lastNode.parent().leftChild();                
//     }
// }        
// // Go down along right children until you reach an external node.  
// // Its parent is the new Last Node.
// while (! isExternal(lastNode))
//    lastNode = lastNode.rightChild();        
// lastNode=lastNode.parent();
//}   
//}
//
//
