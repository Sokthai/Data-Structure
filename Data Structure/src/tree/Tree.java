package tree;
import java.util.Iterator;

public interface Tree<E> extends Iterable<E>{
	Position<E> root();
	Position<E> parent(Position<E> p) throws IllegalStateException;
	Iterable<Position<E>> children(Position<E> p) throws IllegalStateException;
	int numChildren(Position<E> p) throws IllegalStateException;
	boolean isInternal(Position<E> p) throws IllegalStateException;
	boolean isExternal(Position<E> p) throws IllegalStateException;
	boolean isRoot(Position<E> p) throws IllegalStateException;
	int size();
	boolean isEmpty();
	Iterator<E> iterator(); //it is from Iterable<E>. for using with For Each Loop
	
	Iterable<Position<E>> positions(); //returns an iterable collection of all position of the tree 
}
