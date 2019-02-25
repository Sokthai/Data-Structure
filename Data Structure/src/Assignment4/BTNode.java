package Assignment4;
//Program: BTNode
//Written by: Sokthai Tang
//Program Description: This class provides the complete structure of the tree
//File name: BTNode.java
//File description: proper tree structure
//Challenges:
//Time Spent: 20 minutes
//Specified Output:                      <-- for client/tester class only, the output specified by the assignment
//--------------------         
//Actual Output:                      <-- for client/tester class only, copy & paste the actual output of your program
//--------------------  
//        Revision History
//Date:04/12/2016      				By:ST                  Created


public class BTNode <E>
{
	private BTNode<E> left, right, parent;
	private E element;
	
	 BTNode ( ){
	     this(null,null,null,null);
	 }

	 BTNode(BTNode <E> p, BTNode <E> l, BTNode <E> r, E e){
		left = l;
		right = r;
		parent = p;
		element = e;
	 }
 
 
	 void setLeftChild(BTNode <E>  v) {
		 left = v;
	 }
	
	 
	 void setRightChild(BTNode <E>  v){
		 right = v;
	 }
	 
	
	 void setParent(BTNode <E>  v) {
		 parent = v;
	 }
	
	 void setElement(E e) {
		 
		 element = e;
	 }
	
	 public BTNode <E>  leftChild() {
		 return left;
	 }
	
	 public BTNode <E>  rightChild() {
		 return right;
	 }
	
	 public BTNode <E>  parent()  {
		 return parent;
	 }
	
	 public  E element()  {
		 return element;
	 }
	 
	 public String toString() { 
		 return (String) element;
	 }
 
}
