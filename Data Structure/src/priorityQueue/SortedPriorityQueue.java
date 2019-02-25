package priorityQueue;

import java.util.Comparator;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>{
	private PositionalList<Entry<K, V>> list = new LinkedPostionalList<>();

	public SortedPriorityQueue(){
		super();
	}

	public SortedPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	public Entry<K, V> insert(K key, V value){//runtime O(n)
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		Position<Entry<K, V>> walk = list.last();
		//walk backward, looking for the smaller key
		while(walk != null && compare(newest, walk.getElement()) < 0){
			walk = list.before(walk);
		}
		if (walk == null)
			list.addFirst(newest);
		else
			list.addAfter(walk, newest);
		
		return newest;
	}

	
	public Entry<K, V> min(){
		if (list.isEmpty()) return null;
		return list.first().getElement();
	}
	
	public Entry<K, V> removeMin(){
		if (list.isEmpty()) return null;
		return list.remove(list.first());
	}
	
	
	public int size(){
		return list.size();
	}
}
