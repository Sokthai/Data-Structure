package Assignment5;


//Program: PromotionPointsSystem
//Written by: Margie Bleichman
//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//File name: PriorityQueue.java 
//File description: This builds a linked Binary Tree (simplified -- needs exception handling.)
//Java Files in this program:  
//BTNode, BinaryTree, Heap, PriorityQueue
//Emp, PromotionPointsSystem, PromotionPointsSystemTester, PromotionQueue, PriorityQueueException
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//04/20/2012        (mb)                Created
 // This set is a transparent layer of methods calling their counterparts in the BTNode layer
//protected BTNode <E> parent (BTNode <E> v) 	{return v.parent(); }
//protected BTNode <E> leftChild (BTNode <E> v)	{return v.leftChild(); }
//protected BTNode <E> rightChild (BTNode <E> v)	{return v.rightChild();}
//protected E element (BTNode <E> v)		{return v.element();}
public class BinaryTree <E>
{    
	public BTNode <E> root = new BTNode<>();  // starts out with just a root, which is external and empty
	protected int size = 1; // how many nodes are in the tree
	
	public int size() {
		return size;
	}
	
	protected void replaceElement(BTNode <E> v, E e){
		v.setElement(e);
	
	}
	
	protected boolean isRoot(BTNode <E> v){ // Node is root if parent is null
		return (v.parent() == null);    
    }

	protected boolean isInternal(BTNode<E>  v){ //Node is internal if it has at least one child
		return (v.leftChild() != null || v.rightChild() != null);    
    }

	protected boolean isExternal(BTNode<E>  v){//Node is external if both children are null
		return (v.leftChild() == null && v.rightChild() == null);    
    }

	protected boolean isRightChild(BTNode<E> v){//Node is right child if it equals its parent's right child
		if (isRoot(v)) return false;
		return (v == (v.parent()).rightChild());    
    }

	protected boolean isLeftChild(BTNode<E>  v){//Node is left child if it equals its parent's left child
		if (isRoot(v)) return false;
		return (v == (v.parent()).leftChild());    
	}

	protected void swapElements(BTNode<E>  v, BTNode<E>  x){
		E temp = v.element();
     	v.setElement(x.element());
     	x.setElement(temp);    
    }

	protected BTNode<E>  sibling(BTNode<E>  v) throws BinaryTreeException {
	    // if (v.parent()==null) throw new BinaryTreeException ("sibling():  null parent");
	     if (v == v.parent().rightChild())
	     	return (v.parent()).leftChild();
	     else
	     	return (v.parent()).rightChild();    
     }

	protected void expandExternal(BTNode<E>  v) {
		
	     if (!isExternal(v)){ return;}  // tbd: return exception here
	     BTNode<E>  newLeft  = new BTNode(v, null, null, null);
	     v.setLeftChild(newLeft);
	     BTNode<E>  newRight = new BTNode(v,null, null, null);
	     v.setRightChild(newRight);
		    size +=2;
		 
	}

	protected void removeAboveExternal(BTNode<E>  v) throws BinaryTreeException {
        BTNode<E>  p = v.parent(); 	// going to be looking at parent a lot
        if (!isExternal(v)) return; // tbd: return exception here
        if (isRoot(v)) return; 		// tbd: return exception here
        if (isRoot(p)) // if we are removing the root node, the left child becomes the new root!  No internal nodes.
        {   root = root.leftChild();
            root.setParent(null);        }
       else
        {
       	// set the parent's parent to point to the sibling of the node that's being deleted
        if (isRightChild(p))
        	(p.parent()).setRightChild(this.sibling(v));
        else
            (p.parent()).setLeftChild(this.sibling(v));}
        this.sibling(v).setParent(p.parent());	// set the sibling's parent to the parent's parent
                      //set up for garbage collection
        v.setParent(null);
        p.setParent(null);
        p.setRightChild(null);
        p.setLeftChild(null);
        size -=2;    
        }
}
