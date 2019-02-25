package binA3;
// Program:  List 
// Written by: Margie Bleichman
// Program Description:  The program will implement an Index-based List with a Node based Singly Linked List.
// File name: ListADT.java (List Abstract Data Type)
// File description: This is a Java Interface that provides the ADT to be used to implement a List Class.
//      This interface uses generics.  
//      List.java should implement this interface, using generics as well.
// Files in this program:  
//      To be written by student: SLL.java, List.java
//      Provided by professor:    ListADT.java, SLLADT.java, SLLNode.java, SLLBoundsException.java
//                                ListTester1.java, ListTester2.java, Person.java
//      Note: DO NOT MODIFY the provided files 
// Revision History:
// Date:                   By:               Action:
// ---------------------------------------------------
// 2/22/2016                mb          created


public interface  ListADT <E> {
 
  // provide the number of elements in the list
  public int size() ;

  // is the stack empty?
  public boolean isEmpty() ;

  // return the first element without removing it 
  public E first() throws SLLBoundsException ;
  
  // return the last element without removing it 
  public E last() throws SLLBoundsException ;
  
  // Add an element to the front of the list
  public  void  insertFirst(E obj) ;
  
  // Add an element to the end of the list
  public  void  insertLast(E obj) ;

  // Remove an element off the front of the list and returns it
  public E removeFirst() throws SLLBoundsException ;
  
   // Remove an element off the end of the list and returns it
  public E removeLast () throws SLLBoundsException ;
  
  //Returns the index of the first occurrence of an element in this list that "is equal to" the given element,
  //or -1 if the list does not contain the element
  public int getIndexOf(E e);
  
  //Returns the element at the specified position in this list.
  public E getElementAt(int index) throws SLLBoundsException ;
  
  //Removes the element at the specified position in this list and returns it
  public E removeAt(int index) throws SLLBoundsException ;

  //Inserts the specified element at the specified position in this list.
  public void insertAt (int index, E element) throws SLLBoundsException ;
  
  // a method that can be used to get a string of the whole list
  public String toString() ;
  
}