package stack;

public interface Stack<E> { //LIFO Principle
int size();
boolean isEmpty();
void push(E e); //add
E pop(); //remove
E top();
}
