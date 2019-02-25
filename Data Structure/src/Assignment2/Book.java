
package Assignment2;
//Program: Shopping cart
//Written by: Sokthai Tang
//Program Description: Book items to be add in the cart
//File name: Book.java
//File description: This program is called in the Shopping class to add in the cart item
//Other files in this project:
//Challenges:
//Time Spent: 15min
//Specified Output:                      <-- for client/tester class only, the output specified by the assignment
//--------------------         
//Actual Output:                      <-- for client/tester class only, copy & paste the actual output of your program
//--------------------  
//                Revision History
//Date:02/10/2016      				By:ST                  Created
//Date:02/14/2016                   By:ST                  Action: Add Precondition and Postcondition
//---------------------------------------------------
public class Book {
    private String title ;
    private String ISBN;
     
    /**
     * Set title and ISBN
     * Precondition: title != null
     * Precondition: ISBN != null
     * Postcondition: this.title == title 
     * Postcondition : this.ISBN == ISBN
     * @param name
     */

    public Book(String title , String ISBN){
    	assert title != null: "title can't be empty";
    	assert ISBN != null: "ISBN can't be empty";
        this.title  = title ;
        this.ISBN = ISBN;
        assert this.title == title: "title is not matched";
    	assert this.ISBN == ISBN: "ISBN is not matched";
    }
    
    /**
     * Return String
     * Precondition: get Title and ISBN  
     * Postcondition : return the message
     * @return
     */
    
     public String toString(){
    	 
    	 assert title != null && ISBN != null: "title and ISBN cannot be null";
        return String.format("Title: %s, ISBN: %s", title, ISBN);
    }
    
    
}
