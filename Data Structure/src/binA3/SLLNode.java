package binA3;



//Program: List 
//Written by: Margie Bleichman
//Program Description:  The program will implement an Index-based List with a Node based Singly Linked List.
//File description: This is the SLLNode used to implement the Singly Linked List, using generics.
//   This is a solution for the Singly Linked List assignment.
//Files in this program:  
//   To be written by student: SLL.java, List.java
//   Provided by professor:    ListADT.java, SLLADT.java, SLLNode.java, SLLBoundsException.java
//                             ListTester1.java, ListTester2.java, Person.java
//   Note: DO NOT MODIFY the provided files
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//03/15/2012       (mb)                Created

public class SLLNode <E> 
{
	private E element;
	private SLLNode <E>  nextNode;

	//constructor: requires object to store, reference to next node
	public  SLLNode(E e, SLLNode <E>  n){
		element = e;
		nextNode = n;
	}

	// provide the object that was stored in the node
	public E getElement(){return element;}

	// provide the link to the next node
	public SLLNode <E>  getNextNode(){return nextNode;}

	// Change the object stored in the node
	public void setElement(E e){element = e;}

	// Change the reference to the next node
	public void setNextNode(SLLNode <E>  n){nextNode = n;}
     
              public String toString () {return element.toString();}

}
