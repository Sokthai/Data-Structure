package Assignment3;

//Program:  List 
//Written by: Margie Bleichman
//Program Description:  The program will implement an Index-based List with a Node based Singly Linked List.
//File name: SLLADT.java (Singly Linked List Abstract Data Type)
//File description: This is a Java Interface that provides the ADT 
// to be used for the implementation of a SLL Class.
// This interface uses generics.  
// SLL.java should implement this interface, using generics as well.
//Files in this program:  
// To be written by student: SLL.java, List.java
// Provided by professor:    ListADT.java, SLLADT.java, SLLNode.java, SLLBoundsException.java
//                           ListTester1.java, ListTester2.java, Person.java
// Note: DO NOT MODIFY the provided files 
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//03/15/12         mb             Created
//02/25/14         mb             Updated with index-based methods
//02/22/16         mb             Simplified:  moved index-based methods to List ADT

public interface  SLLADT <E> {

//provide the number of elements in the list
public int size() ;

//is the stack empty?
public boolean isEmpty() ;

//return the first element without removing it 
public E first() throws SLLBoundsException ;

//return the last element without removing it 
public E last() throws SLLBoundsException ;

//Add an element to the front of the list
public  void  insertFirst(E obj) ;

//Add an element to the end of the list
public  void  insertLast(E obj) ;

//Remove an element from the front of the list
public E removeFirst() throws SLLBoundsException ;

//Remove an element from the end of the list  
public E removeLast() throws SLLBoundsException ;

//a method that can be used to get a string of the whole list
public String toString() ;
}
