package binA3;

//Program: List 
//Written by: Margie Bleichman
//Program Description:  The program will implement an Index-based List with a Node based Singly Linked List.
//File name: SLLBoundsException.java
//File description: This provides the exception class for Singly Linked List.
//   This exception is thrown when an action is requested that cannot be performed on an empty list.
//   This is one of the required files provided for the List assignment.
//Files in this program:  
//   To be written by student: SLL.java, List.java
//   Provided by professor:    ListADT.java, SLLADT.java, SLLNode.java, SLLBoundsException.java
//                             ListTester1.java, ListTester2.java, Person.java
//   Note: DO NOT MODIFY the provided files 
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//03/15/2012       (mb)                Created
public class SLLBoundsException extends RuntimeException {  
public SLLBoundsException(String err) {
 super(err);
}
}