package Assignment5;

//Program: PromotionPointsSystem
//Written by: Margie Bleichman
//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//File name: PriorityQueueException.java
//File description: This exception supports the PriorityQueue.  It is used when trying to remove from an empty queue.
//Java Files in this program:  
//BTNode, BinaryTree, Heap, PriorityQueue
//Emp, PromotionPointsSystem, PromotionPointsSystemTester, PromotionQueue, PriorityQueueException
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//04/20/2012        (mb)                Created
public class PriorityQueueException extends Exception{
 
 public PriorityQueueException(){
     this("Priority Queue Exception");
 }
 
 public PriorityQueueException(String message){
     super(message);
 }
}
