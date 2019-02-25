package Assignment3;
// Program:  List
// Written by: Margie Bleichman
// Program Description:  The program will implement an Index-based List with a Node based Singly Linked List.
// File name: ListTester2.java (List client)
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



public class ListTester2
{
	public static void main (String[] args){
    	List<Person> L = new List();
        int j;
    	Person a, b, c, d, e, f, g, h, p;
	try{
System.out.println ("ListTester2 Output:\n"); System.out.print (L); System.out.println("   Is the list emptyppp?  "+L.isEmpty());	
            a = new Person ("Amy");  L.insertLast( a);                        
            System.out.print("Inserted Last: " + a + ". "); System.out.println (L);
            b = new Person ("Bill");  L.insertLast( b);
            System.out.print("Inserted Last: " + b + ". "); System.out.println (L);
            c = new Person ("Carl");  L.insertLast( c);
            System.out.print("Inserted Last: " + c + ". ");  System.out.println (L);

            System.out.print("There are  " + L.size() + " persons in the list. ");	
            System.out.print("First: " + L.first() + ". ");	
            System.out.println("Last: " + L.last() + ". ");

System.out.println();
            d = new Person ("Dan");  L.insertFirst(d);
            System.out.print("Inserted First: " + d + ". "); 	System.out.println (L);
            e = new Person ("Ella");  L.insertFirst( e);
            System.out.print("Inserted First: " + e + ". "); 	System.out.println (L);
            f = new Person ("Fran");  L.insertFirst( f);                        
            System.out.print("Inserted First: " + f + ". ");   System.out.println (L);

            System.out.print("There are  " + L.size() + " persons in the list. ");System.out.println("   Is the list empty?  "+L.isEmpty());	
            System.out.print("First: " + L.first() + ". ");	
            System.out.println("Last: " + L.last() + ". ");
        
System.out.println();
            System.out.print("Removed Last: " + L.removeLast() +". ");System.out.println (L);
            System.out.print("There are  " + L.size() + " persons in the list. ");
            System.out.println("Is the list empty?  "+L.isEmpty());	            
            g = new Person ("Georgia");  L.insertLast(g); 
            System.out.print("Inserted Last: " + g + ". "); System.out.println (L);
            System.out.print("Removed Last: " + L.removeLast() +". ");System.out.println (L);      
            
// These calls will work if Generic has been passed down properly through all levels:
System.out.println(); System.out.print("Test Generics:  ");
            System.out.print("ID of first person: " + L.first().getID()+ ". ");
            System.out.println("Name of last person: " + L.last().getName()+ ". ");                         
            
// Test Index-based methods:          
System.out.println(); System.out.println("Test index based methods:");                     
           System.out.println("A person that equals Georgia is at index: " + L.getIndexOf ( g));  // uses comparison!  use .equals!
           System.out.println("A person that equals Amy is at index: " + L.getIndexOf ( a));  // uses comparison!  use .equals!
          
// Test index based methods at either end of the list:  
// Remove at head index:
System.out.println(); System.out.println("Remove at Head index: ");   System.out.print("The person at index 0 is: " + L.getElementAt(0) + ". "); System.out.println (L);
                        System.out.print("Removed person at index 0: " + L.removeAt(0) + ". "); System.out.println (L); 
                        System.out.println("There are " + L.size() + " persons in the list. ");
//Add at head index:             
System.out.println(); System.out.println("Add at Head index: ");   L.insertAt( 0, c);                                    
                        System.out.print("Inserted person at index 0: " + c + ". ");   System.out.println (L);
                        System.out.println("There are " + L.size() + " persons in the list. ");
////Remove at tail index:                    
System.out.println(); System.out.println("Remove at Tail index: ");   j = L.size()-1;
                        System.out.print("Removed person at index " + j + ": " + L.removeAt(j) + ". "); System.out.println (L);   
                        System.out.println("There are " + L.size() + " persons in the list. ");
// 
// //Add at tail index:
 System.out.println(); System.out.println("Add at Tail index: "); j = L.size();  h = new Person ("Hal");  L.insertAt( j, h);  
                        System.out.print("Inserted person at index " + j + ": " + h + ". ");   System.out.println (L);   
                        System.out.println("There are " + L.size() + " persons in the list. ");
//                         
////Remove at an index in the middle                    
System.out.println(); System.out.println("Remove at middle index:");   j = L.size()-1;
                        System.out.print("Removed person at index " + j/2 + ": " + L.removeAt(j/2) + ". "); System.out.println (L);   
                        System.out.println("There are " + L.size() + " persons in the list. ");
////Add at an index in the middle                       
System.out.println(); System.out.println("Add at middle index:");   j = L.size()-1;  p = new Person ("Peter");  L.insertAt( j/2+1,p);           
                        System.out.print("Inserted person at index  " + (j/2+1) + ": "  + p + ". ");   System.out.println (L);   
                        System.out.println("There are " + L.size() + " persons in the list. ");       
//System.out.println();                      
                        System.out.println (L);
                        System.out.print("Removed First: " + L.removeFirst() + ". ");System.out.println (L);
                        System.out.print("Removed First: " + L.removeFirst() + ". ");System.out.println (L);
                        System.out.print("Removed Last: " + L.removeLast() + ". ");System.out.println (L);                 
                        System.out.print("Removed Last: " + L.removeLast() + ". ");System.out.println (L);
                        System.out.print("Removed Last: " + L.removeLast() + ". ");System.out.println (L);                 
                        System.out.println("There are " + L.size() + " persons in the list. ");                    
                        System.out.println("Is the list empty?  "+L.isEmpty());	
// force exception:
                       //System.out.println("The next removeFirst() should cause an exception: " ); 
                       //System.out.print("Removed First: " + L.removeFirst() + ". ");  System.out.println (L);
                    }
                    catch (Exception ex)
                    {System.out.println ("Error: "+ ex.getMessage());}
	}
}