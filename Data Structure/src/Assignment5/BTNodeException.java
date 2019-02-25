package Assignment5;



public class BTNodeException extends Exception{
    
    public BTNodeException(){
        this("Binary Tree Node Exception");
    }
    
    public BTNodeException(String message){
        super(message);
    }
}

