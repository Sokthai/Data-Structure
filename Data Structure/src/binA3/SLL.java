/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binA3;

/**
 *
 * @author Bin
 */
public class SLL<E> implements SLLADT<E>{
    protected SLLNode<E> head = null;
    protected SLLNode<E>tail=null;
    protected int size =0;
    
  // provide the number of elements in the list
  @Override
  public int size(){return size;}

  // is the stack empty?
  @Override
  public boolean isEmpty(){ return size==0;}

  // return the first element without removing it 
    @Override
  public E first() throws SLLBoundsException {
            if (isEmpty()) return null;
          return head.getElement();
  }
  
  // return the last element without removing it 
    @Override
  public E last() throws SLLBoundsException {
      if (isEmpty()) return null;
          return tail.getElement();
  };
  
  // Add an element to the front of the list
    @Override
  public  void  insertFirst(E obj){

      head=new SLLNode<>(obj,head);
      if (size==0)
         tail=head;
         size++;
  }
  
  // Add an element to the end of the list
  public  void  insertLast(E obj) {

      SLLNode<E>newest= new SLLNode<>(obj,null);
      if (isEmpty())
          head=newest;
      else
          tail.setNextNode(newest);
      tail=newest;
      size++;
      
  }

  // Remove an element from the front of the list
  public E removeFirst() throws SLLBoundsException{

      if (isEmpty()) return null;
      E element = head.getElement();
          head=head.getNextNode();
          size--;
          if(size==0)tail=null;
          return element;
  }
  
  // Remove an element from the end of the list  
  public E removeLast() throws SLLBoundsException {
    SLLNode<E> currentHead = head;
    SLLNode<E>preHead=null;
    E element = null;
    if (currentHead.getNextNode() == null) {
    	head = null;
    	tail = null;
    	size--;
    	return currentHead.getElement();
    }
    
  
    while(currentHead != null){
    	if (currentHead.getNextNode() == null)
    		  element = currentHead.getElement();
    	currentHead = currentHead.getNextNode();
    }
  
    
   currentHead = head;
    
    
    
    
       while(currentHead.getNextNode() != null) {
          preHead = currentHead;
          currentHead = currentHead.getNextNode();
        
    }
       preHead.setNextNode(null);
       tail = preHead;
       size--;
      return element;
  }
  
  // a method that can be used to get a string of the whole list
  public String toString(){
    String msg="";
    SLLNode<E> currentHead=head;
    //head    
    if(isEmpty())
        return "This List looks like this: Empty";
    //tail
    if(currentHead.getNextNode()==null)
         return "The List looks like this:" + currentHead.getElement();
//traverse the list of nodes
    for(int i = 0; i < size; i++){
         msg+= currentHead.getElement().toString() + " ";
         currentHead = currentHead.getNextNode();
         
     }
     //return the string and concatenated msg
    return "The List looks like this: " + msg;
}
    
}