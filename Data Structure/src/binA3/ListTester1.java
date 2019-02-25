package binA3;


// Program:  List
// Written by: Margie Bleichman
// Program Description:  The program will implement an Index-based List with a Node based Singly Linked List.
// File name: ListTester1.java (List client)
// File description: This is a tester for an Index-based List Class implemented using generics.
// Files in this program:  
//      To be written by student: SLL.java, List.java
//      Provided by professor:    ListADT.java, SLLADT.java, SLLNode.java, SLLBoundsException.java
//                                ListTester1.java, ListTester2.java, Person.java
//      Note: DO NOT MODIFY the provided files
// Revision History:
// Date:                   By:               Action:
// ---------------------------------------------------
// 02/22/2016       mb              created List Tester
public class ListTester1
{
	public static void main (String[] args){
        Integer i;
    	List<Integer> L = new List();
    	Integer n;
                 System.out.println ("ListTester1 Output:\n");
                 try{
                        System.out.println (L);
                        n = new Integer (11);  L.insertLast( n);
                      
                        System.out.print("Inserted Last: " + n + ". "); System.out.println (L);
                        n = new Integer (33);  L.insertLast( n);
                        System.out.print("Inserted Last: " + n + ". "); System.out.println (L);
                        n = new Integer (55);  L.insertLast( n);
                        System.out.print("Inserted Last: " + n + ". ");  System.out.println (L);

                        System.out.print("There are  " + L.size() + " elements in the list. ");	
                        System.out.print("First:    " + L.first() + ". ");	
                        System.out.println("Last:    " + L.last() + ". ");	
                        
                        System.out.print("Removed First: " + L.removeFirst() +". ");System.out.println (L);
                        System.out.print("Removed Last: " + L.removeLast() +". ");System.out.println (L);
                        System.out.println("There are  " + L.size() + " elements in the list. ");
                        System.out.println("Is the list empty?  "+L.isEmpty());	

                        n = new Integer (22);  L.insertFirst( n);
                        System.out.print("Inserted First: " + n + ". "); 	System.out.println (L);
                        n = new Integer (44);  L.insertLast( n);
                        System.out.print("Inserted Last: " + n + ". "); 	System.out.println (L);
                        n = new Integer (66);  L.insertFirst( n);                        
                        System.out.print("Inserted First: " + n + ". ");   System.out.println (L);

                        System.out.print("There are  " + L.size() + " elements in the list. ");
                        System.out.print("First:    " + L.first() + ". ");	
                        System.out.println("Last:    " + L.last() + ". ");	
                        System.out.println();
                        
// Test index based methods:
                        System.out.print("The element at index 1 is:    " + L.getElementAt(1) + ". "); System.out.println (L);
                        System.out.print("Removed element at index 1:    " + L.removeAt(1) + ". "); System.out.println (L);   
                        n = new Integer (99);  L.insertAt( 2, n);  
                        System.out.print("Inserted element at index 2: " + n + ". ");   System.out.println (L);
                        System.out.println("The element equivalent to 44 is at index:  " + L.getIndexOf ( new Integer(44)));  // uses comparison!  use .equals!
                        System.out.println("The element equivalent to 10 is at index:  " + L.getIndexOf ( new Integer(10))); 
                        System.out.println();
//                        
                        System.out.print("Removed First: " + L.removeFirst() +". ");System.out.println (L);
                        System.out.print("Removed Last: " + L.removeLast() +". ");System.out.println (L);
                        System.out.println("There are  " + L.size() + " elements in the list. ");	
//
                        System.out.print("Removed First: " + L.removeFirst() + ". ");System.out.println (L);
                        System.out.print("Removed Last: " + L.removeLast() + ". ");System.out.println (L);
                        System.out.println("Is the list empty?  "+L.isEmpty());	
// This one should force exception:
                        //System.out.println("The next removeFirst() should force an exception: ");
                        //System.out.print("Removed First: " + L.removeFirst() + ". ");System.out.println (L);
                    }
                    catch (Exception e)
                    {System.out.println ("Error: "+ e.getMessage());}
	}
}