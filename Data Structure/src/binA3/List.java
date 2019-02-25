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
public class List<E>extends SLL<E> implements ListADT <E>{
     

 
  //Returns the index of the first occurrence of an element in this list that "is equal to" the given element,
  //or -1 if the list does not contain the element
     @Override
  public int getIndexOf(E e){
      SLLNode<E> currentHead = super.head;
      
      int i=0;
      while (currentHead != null ){
    	  if (currentHead.getElement().equals(e)) return i;
          i++;
          currentHead=currentHead.getNextNode();
      }
     
     return -1;
      
  }
  //return the node will need to find by given index
   private SLLNode<E> findNodeAt (int index) throws SLLBoundsException{

       SLLNode<E> currentHead = super.head;
       int i=0;
       while (i<=index){
       if (i==index)
          break;
         currentHead=currentHead.getNextNode();
      i++;  
       }
    
       return currentHead;
  }
   

  //Returns the element at the specified position in this list.
     @Override
  public E getElementAt(int index) throws SLLBoundsException {
      SLLNode<E> currentHead=findNodeAt(index);
     
      
      
      return currentHead.getElement();
              
  }
  
  //Removes the element at the specified position in this list and returns it
     @Override
  public E removeAt(int index) throws SLLBoundsException {
      SLLNode<E> node = findNodeAt(index);
      
      
      SLLNode<E>currentHead=head;
      SLLNode<E>preHead=null;
    
      if (head == node){
    	  head = head.getNextNode();
    	  	  
      }else{
     
    	  while (!node.getElement().equals(currentHead.getElement())){
	    	
	         preHead = currentHead;
	         currentHead=currentHead.getNextNode();
	        
    	  }
    	  preHead.setNextNode(currentHead.getNextNode());  
//    	  if (node == tail) tail = currentHead;
     }
       
    
     size--;
     
     
     
     
//     System.out.println("Remove AT method");
    
      return currentHead.getElement();
      
  }

  //Inserts the specified element at the specified position in this list.
  public void insertAt (int index, E element) throws SLLBoundsException {
      SLLNode<E> node = findNodeAt(index);
   

      SLLNode<E>currentHead=head;
      SLLNode<E>preHead=null;
      SLLNode<E>newest=new SLLNode<E>(element,node);
     
      
      
      if (node == head){
    	  head = newest;
      }else{    
	      while (node != currentHead){
	          preHead=currentHead;
	          currentHead=currentHead.getNextNode();
	      }
	      preHead.setNextNode(newest);
      }
      size++;
  }
  

 
    
}