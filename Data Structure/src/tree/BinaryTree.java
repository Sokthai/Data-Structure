package tree;

public interface BinaryTree<E> extends Tree<E> {
	Position<E> left(Position<E> p) throws IllegalArgumentException; //return the Position of p's left child (null if no child)
	Position<E> right(Position<E> p) throws IllegalArgumentException;  //return the Position of p's right child (null if no child)
	Position<E> sibling(Position<E> p) throws IllegalArgumentException; //return the Position of p's sibling (null if no sibling)
}
