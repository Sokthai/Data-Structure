package tree;
import java.util.ArrayList;
import java.util.List;
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E>{
	
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException{ //return sibling
		Position<E> parent = parent(p);
		if (parent == null) return null; //make sure the binary tree is proper. meaning it has children (left and right)
		if (p == left(parent))
			return right(parent);
		else
			return left(parent);
	}
	
	public int numChildren(Position<E> p){ //return number of children of Position p.
		int count = 0;	
		if (left(p) != null)
			count++;
		if (right(p) != null)
			count++;	
		return count;
	}
	
	
	//return an iterable collection of the Positions representing p's children.
	public Iterable<Position<E>> children(Position<E> p){
		List<Position<E>> snapshot = new ArrayList<>(2);//max capacity of 2
		
		if (left(p) != null)
			snapshot.add(left(p));
		if (right(p) != null)
			snapshot.add(right(p));
		return snapshot;
	}
	
	
	
	
	
	
	
	
	
	
	
}
