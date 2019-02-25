package mapADT_hashADT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// do not use Hash for this Map, running time is O(n) for many methods. remove, get and put methods
public  class UnsortedTableMap<K, V> extends AbstractMap<K, V>{
	
	private ArrayList<MapEntry<K, V>> table = new ArrayList<>();
	
	public UnsortedTableMap(){ } //Empty constructor;
	
	private int findIndex(K key){
		int n = table.size();
		for (int j = 0; j < n; j++)
			if (table.get(j).getKey().equals(key))
				return j;
		return -1;
	}
	
	public int size(){ return table.size(); }
	
	
	public V get(K key){
		int index = findIndex(key); //if in SEPARATE CHAINING, although we know the index of the hash table in the array.
									//we still have to do a linear search in that sub array only since that sub array 
									//has all the collision object that Hash Function can't distinguish 
		if (index == -1) return null;
		return table.get(index).getValue();
	}
	
	public V put(K key, V value){
		int index = findIndex(key);
		if (index == -1){
			table.add(new MapEntry<>(key, value));
			return null;
		}else{
			return table.get(index).setValue(value);			
		}
	}
	
	public V remove(K key){
		int index = findIndex(key);
		int n = table.size();
		if (index == -1) return null;
		V answer = table.get(index).getValue();
		if (index != n - 1)
			table.set(index, table.get(n - 1)); //we copy the last elements to the index that we want to delete
		table.remove(n - 1); 			//we delete the last element instead, so the mechanism behind arrayList won't 
											//need to spend time to rearrange itself. Why we do that?
										//because we already have findIndex(key) that we create by our own that do this already. 
			
		return answer;
	}
	
	
	//=================CLASS===================================================
	//Support for public entrySet method...
	private class EntryIterator implements Iterator<Entry<K, V>>{
		private int j = 0;
		public boolean hasNext() { return j < table.size(); }
		public Entry<K, V> next(){
			if (j == table.size()) throw new NoSuchElementException();
			return table.get(j++);
		}
		public void remove() {throw new UnsupportedOperationException(); }
	}
	
	//=============END CLASS====================================================
	
	private class EntryIterable implements Iterable<Entry<K, V>>{
		public Iterator<Entry<K, V>> iterator() { return new EntryIterator(); }
	}
	
	public Iterable<Entry<K, V>> entrySet(){
		return new EntryIterable();
	}

}
	
