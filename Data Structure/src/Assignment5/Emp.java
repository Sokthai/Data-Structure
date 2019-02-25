package Assignment5;


//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//File name: Emp.java
//File description: This is an Employee class that implements Comparable by contatining the compareTo() method
//   so that two Employees can be compared during the PriorotyQueue processing.
//Java Files in this program:  
//BTNode, BinaryTree, Heap, PriorityQueue
//Emp, PromotionPointsSystem, PromotionPointsSystemTester, PromotionQueue, PriorityQueueException
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//04/20/2012        (mb)                Created

public class Emp implements Comparable {
 private String Name;
 private String ID;
 private String Department;	
 private int promoPoints;
 
 public Emp (String n, String i, String d, int p){
     Name = n;
     ID = i;
     Department = d;
     promoPoints = p;
 }
 
 // compare Employees by their promoPoints returns - if less, + if greater, 0 if equal
 // Because Emp implements Comparable, the parameter of compareTo() must be Object, so cast to Emp
 public int compareTo(Object other) {
     return (this.promoPoints - ((Emp) other).promoPoints);
 }
             
 public String toString (){
     return (Name + " " + ID + " " + Department + " " + promoPoints);
 }
}