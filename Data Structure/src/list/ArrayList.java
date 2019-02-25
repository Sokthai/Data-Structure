package list;
//April-03-16 chapter 7 List

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private E[] data;
	private int size = 0;
	private static final int  CAPACITY = 16;
	
	
	public ArrayList(){
		this(CAPACITY);
	}
	
	public ArrayList(int capacity){
		data = (E[])new Object[capacity];
	}
	
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public E get(int i)throws IndexOutOfBoundsException{
		checkIndex(i, size);
		return data[i];
	}
	
	public E set(int i, E e)throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E old = data[i];
		data[i] = e;
		return old;
	}
	
	public void add(int i, E e)throws IndexOutOfBoundsException, IllegalStateException{
		checkIndex(i, size + 1);
		if (size == data.length){
			throw new IllegalStateException("Array is full");
		} 
		for (int k = size - 1; k >= i; k--){  //shifting from big to small
			data[k + 1] = data[k];
		}
		data[i] = e;
		size++;
	}
	
	public E remove(int i)throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E old = data[i];
		for (int k = i; k < size - 1; k++){ //shifting from small to big
			data[k] = data[k + 1];
		}
		data[size--] = null;
		return old;
		
		
		
		
	}
	
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if ((i < 0) || (i >= n)){
			throw new IndexOutOfBoundsException("Illegal index " + i);
		}
		
	}
	
	
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}

	
	//=============nested ArrayIterator class =========================
	
	public class ArrayIterator implements Iterator<E>{
		private int j = 0;
		private boolean removable = false;
		
		public boolean hasNext(){
//			System.out.println("has next");
			return j < size;
			
		}
		
		public E next() throws NoSuchElementException{
			if (j == size) throw new NoSuchElementException("No next element");
			removable = true;
//			System.out.println("blah blah in next");
			return data[j++];
		}
		
		public void remove() throws IllegalStateException{
			if (!removable) throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j - 1); //call the outer class "ArrayList" remove(int i ) method
			j--;
			removable = false;
		}
		
	}//end ArrayIterator Class
	
	//===================================================
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//=================
	
	public static void main (String[] args){
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		
		try{
			System.out.println(arrayList.size());
			arrayList.add(arrayList.size(), new Integer(1));
			arrayList.add(arrayList.size(), new Integer(2));
			arrayList.add(arrayList.size(), new Integer(3));
			arrayList.add(arrayList.size(), new Integer(4));
			arrayList.add(arrayList.size(), new Integer(5));
			arrayList.add(arrayList.size(), new Integer(6));
			arrayList.add(arrayList.size(), new Integer(7));
			arrayList.add(arrayList.size(), new Integer(8));
			arrayList.add(arrayList.size(), new Integer(9));
			arrayList.add(arrayList.size(), new Integer(10));
			arrayList.add(arrayList.size(), new Integer(11));
			arrayList.add(arrayList.size(), new Integer(12));
			arrayList.add(arrayList.size(), new Integer(13));
			arrayList.add(arrayList.size(), new Integer(14));
			arrayList.add(arrayList.size(), new Integer(15));
			arrayList.add(arrayList.size(), new Integer(16));
//			arrayList.add(arrayList.size(), new Integer(17));
			
			System.out.println(arrayList.size());
			System.out.println("========================");
			for (Integer i : arrayList){
				
				System.out.println(i);
			}
			System.out.println("========================");
			Iterator<Integer> iter = arrayList.iterator();
			
			while (iter.hasNext()){
				Integer i = iter.next();
				System.out.println(i);
			}
		
			
			
		}catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}catch (IllegalStateException e){
			System.out.println(e.getMessage());
		}
	}//end main class
	
}











