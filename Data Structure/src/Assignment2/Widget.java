/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

//Program: Shopping cart
//Written by: Sokthai Tang
//Program Description: Widget items to be add in the cart
//File name: Widget.java
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
public class Widget {
    private String color, size;
    
    /**
     * Set color and size
     * Precondition: color != null
     * Precondition: size != null
     * Postcondition: this.title == title 
     * Postcondition : this.ISBN == ISBN
     * @param name
     */
    
    
    public Widget(String color, String size){
    	
    	assert color != null: "color can't be empty";
    	assert size != null: "size can't be empty"; 	
    	
        this.color = color;
        this.size = size;
        
        assert this.color == color: "color is not matched";
    	assert this.size == size: "size is not matched";
    }
    
    /**
     * return message
     * Precondition: size and ISBN are not null
     * Postcondition : return the message
     * @return name
     */
    
    public String toString(){
    	assert size != null && color != null: "size and color can't be null";
    			
        return String.format("A %s %s widget.", size, color);
    }
    
    
    
}
