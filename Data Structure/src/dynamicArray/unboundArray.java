package dynamicArray;
//April - 03 - 2016 chapter 7 (dynamic array) 
/**
	==Unbounded Array (ArrayList) Algorithm==
	if user defined an array with 10 elements, and the maximum index is reached, 
	we have an internal array that has twice of elements (20 element) of the user defined one.
	then, copy the user defined to the temporary internal one, and copy it back to user defined one, 
	and return it to the user.  
	
*/
public class unboundArray<E> {
	private static final int CAPACITY = 3;
	private E[] data;
	private int size = -1;
	public unboundArray(){
		this(CAPACITY);
	}
	
	public unboundArray(int i){
		data = (E[]) new Object[i];
	}
	
	public int size(){
		return size + 1;
	}
	
	public void add(E e) throws IndexOutOfBoundsException{
		
		if (size >= data.length - 1){
			
//			throw new IndexOutOfBoundsException("Array is full");
			E[] temp = (E[]) new Object[data.length * 2]; //create an internal array twice the length of the user define one
			for (int i = 0; i < data.length; i++){
				temp[i] = data[i];
			}
			temp[++size] = e;
			data = temp; //copy the temporary array to the user defined one
		}else{
			data[size + 1] = e;
			size++;
		}
		
		
	}
	
	public E last(){
		return data[size - 1];
	}
	
	//===============
	
	public static void main (String[] args){
		unboundArray<Integer> unbound = new unboundArray<>();
		
		
		try{
			System.out.println(unbound.size());
			unbound.add(new Integer(10));
			System.out.println(unbound.size());
			unbound.add(new Integer(20));
			System.out.println(unbound.size());
			unbound.add(new Integer(30));
			System.out.println(unbound.size());
			unbound.add(new Integer(40));
			System.out.println(unbound.size());
			
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
