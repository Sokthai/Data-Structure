package Assignment2;
import java.util.ArrayList;
import java.util.List;
//Program: Shopping cart
//Written by: Sokthai Tang
//Program Description: Cart class for adding items
//File name: Cart.java
//File description: This program is called in the Shopping class for adding items
//Other files in this project:
//Challenges:
//Time Spent: 15min
//Specified Output:                      <-- for client/tester class only, the output specified by the assignment
//--------------------         
//Actual Output:                      <-- for client/tester class only, copy & paste the actual output of your program
//--------------------  
//              Revision History
//Date:02/10/2016      				By:ST                  Created
//Date:02/14/2016                   By:ST                  Action: Add Precondition and Postcondition
public class Cart<T> {
   
    private String name;
    private int capacity;
    private int items = 0;
    public int publicNumber;
    public ArrayList<T> myItems;
    
    
    /**
    * Sets the capacity
    * Precondition: cap must be greater than 0
    * Postcondition: myItems != null
    * @param name
    */
    public Cart(String names, int cap){
    	
    	assert cap > 0: "Capacity can not less than 0";   	
        name = names;
        capacity = cap;
        myItems = new ArrayList<>(capacity);
        
        assert myItems != null: "myItems has not been initialize";   	
    }
     
    /**
     * Add items
     * Precondition: Confirm the passing argument is not null
     * Postcondition: items == myItme.size()
     * @param name
     */
    
    public void addItem(T t){   
    	assert t != null: "invalid argument";
        myItems.add(t);
        items++;           
        assert items == myItems.size(): "Items in the cart is not matched";
    };
    
 
    
    /**
     * Add items
     * Precondition: get the message from <T> object
     * Postcondition: return the message from <T> and the header message
     * @param name
     */
    
    public String toString(){
    	assert name != null && items > 0: "name and items cannot be null or zero";
        String msg = String.format("%s has %d items:%n", name, items );
        for (Object classes: myItems){
            msg += String.format("%s%n", classes);
        }
        return msg;
    }
    
}
