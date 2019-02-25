package Assignment5;



//Program: PromotionPointsSystem
//Written by: Margie Bleichman
//Program Description:  The program will implement a Priority Queue based on a Heap based on a linked Binary Tree
//File name: PromotionPointsSystem.java
//File description: This class implements the Promotion Queue.  Note that it "knows" about Employees and 
//   sets the generic to Emp when instantiating the Priority Queue.
//Java Files in this program:  
//BTNode, BinaryTree, Heap, PriorityQueue
//Emp, PromotionPointsSystem, PromotionPointsSystemTester, PromotionQueue, PriorityQueueException
//Revision History:
//Date:                   By:               Action:
//---------------------------------------------------
//04/20/2012        (mb)                Created

public class PromotionPointsSystem implements PromotionQueue{

	 PriorityQueue <Emp> PQ = new PriorityQueue();
	
	 public int howMany() {
		 return PQ.PQSize;
	 }
	 
	 public boolean isEmpty() {
		 return (PQ.PQSize== 0);
	 }
	 
	 public void hire(Emp newEmployee) {
		 try {
			 PQ.insert (newEmployee);
	     } catch(Exception ex){
	    	 System.out.println (ex.getMessage());
	     }
	}
	 
	 public Emp promote(){
	     try {  
	    	 
	    	 return PQ.removeMax();
	     }catch (Exception ex){
	    	 System.out.println ("Error: "+ ex.getMessage()); 
	    	 return null;
	     }
	 }
	 
	 public Emp next(){
		 return PQ.nextMax();
	 }
	 

}

