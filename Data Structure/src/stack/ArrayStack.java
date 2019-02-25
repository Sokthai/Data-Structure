package stack;

public class ArrayStack<E> implements Stack<E> {
public static final int CAPACITY = 1000;
private E[] data;
private int t = -1;

public ArrayStack() {this(CAPACITY);}
public ArrayStack(int capacity){
	data = (E[])new Object[capacity];
}

public int size() {return (t + 1);}

public boolean isEmpty(){return (t == -1);}


//adding
public void push(E e) throws IllegalStateException{
	if (size() == data.length) throw new IllegalStateException("Stack is full");
	data[++t] = e;
}
public E top(){
	if (isEmpty()) return null;
	return data[t];
}


//removing
public E pop(){
	if (isEmpty()) return null;
	E answer = data[t];
	data[t] = null;//for the array stack, if user delete an element, we simply assign that element to null. not remove
	t--;
	return answer;
}


public static void main(String[] args){
	ArrayStack stack = new ArrayStack();
	stack.push(new Integer(70));
	System.out.println(stack.pop());
	System.out.println(stack.size());
}

}
