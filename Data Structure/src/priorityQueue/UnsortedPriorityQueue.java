package priorityQueue;

import java.util.Comparator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>{
	private PositionalList<Entry<K, V>> list = new LinkedPostionalList<>();
//	private LinkedPostionalList<Entry<K, V>> list2 = new LinkedPostionalList<>();

	public UnsortedPriorityQueue(){
		super();
	}
	
	public UnsortedPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	private Position<Entry<K, V>> findMin(){ //runtime O(n)
		Position<Entry<K, V>> small = list.first();
		
		for (Position<Entry<K, V>> walk : list.positions()){
			if(compare(walk.getElement(), small.getElement()) < 0){ // if (walk < small) = true
				small = walk;
			}
		}
		return small;
	}
	
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		
		list.addLast(newest);
		return newest;
	}
	
	public Entry<K, V> min(){ //runtime O(n)
		if (list.isEmpty()) return null;
		return findMin().getElement();
	}
	
	public Entry<K, V> removeMin(){ //runtime O(n)
		if(list.isEmpty()) return null;
		return list.remove(findMin());
	}
	
	public int size(){
		return list.size();
	}
	
	
	
	
	
	//======================Main method================================
	public static void main(String[] args){

//		UnsortedPriorityQueue<Integer, String> unsorted = new UnsortedPriorityQueue<>();
	}
	
	
}
