package SLL;//Feb, 28, 2016

public class Node<E> {

    private Node<E> next;
    private E element;

    public Node(Node<E> next, E element) {
        this.next = next;
        this.element = element;
    }

    public Node(E element) {
        this.element = element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E element() {
        return element;
    }

    public String toString() {
        return ("Element: " + element);
    }

}
