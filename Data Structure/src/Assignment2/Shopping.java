package Assignment2;
import java.util.*;
/**
 *
 * @author BLEICHMANM
 */
// Program: Shopping
// Written by: Margie Bleichman
// Program Description:  The program will implement a Shopping system that uses Cart, Grocery, Book and Widget classes.
// File name: Shopping.java (This is the client or tester file.)
// File description: This is a tester for the Cart, Grocery, Book and Widget classes to be written by the student.
// Files in this program:  
//      To be written by student: Cart.java, Grocery.java, Book.java, Widget.java
//      Provided by professor:  Shopping.java
//      Note: DO NOT MODIFY the provided files
//      The Cart class MUST use a generic for the items in the cart!
// Revision History:
// Date:                   By:               Action:
// ---------------------------------------------------
// 01/21/2013      mb               Created
// 2/1/2014        mb               added code that tests the generic
public class Shopping {
    
    public static void main(String[] args){
 
        ArrayList <Cart>  myCarts = new ArrayList<Cart>(); 
        
      
try{
//        Test the Asserts
//          new Cart <Grocery> (null, 2);
//        new Cart <Book> ("", 0);
//        new Grocery(null, .95, 5);
//        new Grocery("A", -.95, 5);     
//        new Grocery("A", .95, -5);  
//        new Book(null, "");
//        new Book("", null);
//        new Widget(null, "");
//        new Widget("", null);
        
        
        Cart <Grocery> c1 =  new Cart <Grocery> ("Greta's Cart of Groceries", 2); 
        Cart <Book> c2 = new Cart <Book> ("Bob's Cart of Books", 3); 
        Cart <Widget> c3 = new Cart <Widget> ("Will's Cart of Widgets", 4);
        
        //Instantiate three Carts, each storing different objects
        myCarts.add (c1) ;
        myCarts.add (c2);
        myCarts.add (c3 );  

        //Add some Groceries to Cart 0
        myCarts.get(0).addItem (new Grocery("Apple", .95, 5));
        myCarts.get(0).addItem (new Grocery("Milk", 1.95, 2));   
        myCarts.get(0).addItem (new Grocery("Bread", 3.59, 1));       

        //Add some Books to Cart 1
        myCarts.get(1).addItem (new Book("Data Structures and Algorithms", "111222333444555"));
        myCarts.get(1).addItem (new Book("Java, How to Program", "998877665544332211"));
        
        //Add some Widgets to Cart 2
        myCarts.get(2).addItem (new Widget("Red", "Medium"));
        myCarts.get(2).addItem (new Widget("Blue", "Small"));
        myCarts.get(2).addItem (new Widget("Yellow", "Large"));
          
              //test changing inside object with enhanced for loop
           //   for (Cart c:myCarts)  {c.setName("AAA");}
        for (Cart c : myCarts)  {
              c.publicNumber=5;
              
        }
                        
       // Now print out all the Carts, which prints out all the Items in each Cart
       for (Cart c : myCarts)  {
           System.out.println(c);
       }
       
       // test using Generic!
       // this should work!
       System.out.println ("Cost of items in Cart 1: ");
       
       for (Grocery x: c1.myItems)
           System.out.println ("Cost: " + x.getCost());
       
       // this should not work: (get incompatible type error)
//       for (Grocery x: c2.myItems)
//           System.out.println ("Cost: " + x.getCost());
    }catch (AssertionError e){
        System.out.print(e.getMessage());
    }
    
    catch (Exception e) {
            System.out.println("Uh oh... There was an error: ");
    }
}
}