package Assignment5;



//Written by: Margie Bleichman
//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//File name: PromotionQueue.java
//File description: This is interface that is implemented by the PromotionsPointsSystem.
//Java Files in this program:  
//BTNode, BinaryTree, Heap, PriorityQueue
//Emp, PromotionPointsSystem, PromotionPointsSystemTester, PromotionQueue, PriorityQueueException
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//04/20/2012        (mb)                Created

public interface PromotionQueue {
 public int howMany();
 public boolean isEmpty();
 public void hire(Emp  newEmployee);
 public Emp promote();
 public Emp next();
}

