
package Assignment2;

//Program: Shopping cart
//Written by: Sokthai Tang
//Program Description: Grocery items to be add in the cart
//File name: Grocery.java
//File description: This program is called in the Shopping class to add in the cart item
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
public class Grocery {
    private String name; 
    private double price;
    private int quantity;
    
    /**
     * Set price, quantity
     * Precondition: price > 0
     * Precondition: quantity > 0
     * Postcondition: this.price == price 
     * Postcondition : this.quantity == quantity
     * @param name
     */
    
    public Grocery(String name, double price, int quantity){
    	assert price > 0: "Price must be greater than 0";
    	assert quantity > 0: "quantity can not less or equal then 0";
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        assert this.price == price: "price is not matched";
        assert this.quantity == quantity: "quantity is not matched";

    }
    
    /**
     * Deliver the total price
     * Precondition: price > 0
     * Precondition: quantity > 0
     * Postcondition: return price * quantity     
     * @return
     */
    
    public double getCost(){
    	assert price * quantity > 0: "return must be greater than 0";
        return price * quantity;
    }
    
    
    /**
     * Precondition: take quantity, name, and price
     * Postcondition: return message for this class 
     * @return
     */
    public String toString(){
        return String.format("%d %s(s), at %.2f each.", quantity, name, price);
    }
}
