package Assignment3;
//Program: List<E>
//Written by: Sokthai Tang
//Program Description: This List Class implement the ListADT and extends SLL class
//File name: List.java
//File description: This class will insert or remove any element the user passing in
//Other files in this project:
//Challenges:
//Time Spent: 1hour
//Specified Output:                      <-- for client/tester class only, the output specified by the assignment
//--------------------         
//Actual Output:                      <-- for client/tester class only, copy & paste the actual output of your program
//--------------------  
//            Revision History
//Date:03/05/2016      				By:ST                  Created
//Date:03/07/2016                   By:ST                  Action: Minimize the redundant code
//Date:03/09/2016					By:ST				   Action: Insert assertions
public class List<E> extends SLL<E> implements ListADT<E>{
	
	
	/**
     * findNodeAt:
     * Precondition: ensure the index is not negative and throw an exception error if out of bound
     * Postcondition: return the node of the given index
     * @param index
     */
	
	private SLLNode<E> findNodeAt (int index) throws SLLBoundsException {
		
		SLLNode<E> current = head();
		
			assert (index >= 0): "index must be equal or greater than 0";
			//throw an out of bound exception error
			if (size() < index) throw new SLLBoundsException("index out of bound!");
			if (size() == index) return null; //null represent for tail 	
			
			for (int i = 0; i <= index; i++){
				if (i == index ){ break; }
				current = current.getNextNode();
			}			
		return current;
		
	}

	
	
	

	//Returns the index of the first occurrence of an element in this list that "is equal to" the given element,
	//or -1 if the list does not contain the element
	public int getIndexOf(E e){
		return getTheIndexOf(e);
	}

	//Returns the element at the specified position in this list.
	public E getElementAt(int index) throws SLLBoundsException {
		SLLNode<E> node = findNodeAt(index);		
		return node.getElement();
		
	}

	//Removes the element at the specified position in this list and returns it
	public E removeAt(int index) throws SLLBoundsException {
		//SLLNode<E> node = findNodeAt(index);
		return remove(findNodeAt(index));
		
	}

	/**
     * insert:
     * Precondition: ensure the element is not null
     * Postcondition: return the node of the given index
     * @param element
     */
	public void insertAt (int index, E element) throws SLLBoundsException {
		SLLNode<E> p = findNodeAt(index);
		SLLNode<E> current = head();
		
		assert (element != null) : "Element cannot be null";
		if (p == current){//if head
			insertFirst(element);
		}else if(p == null){ //if tail
			insertLast(element);
		}else{ //if body of the node
			insertAt(new SLLNode<>(element, p), p);
		}
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
