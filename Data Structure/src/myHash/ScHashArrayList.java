package myHash;

import java.util.ArrayList;

public class ScHashArrayList<K, V>{ //this SeparateChaining with Arraylist
	
//	
	private ArrayList<Entry<K, V>> hashTable;
	private int capacity;
	private int n;
	
	
	
	public ScHashArrayList() {
		this(10);
	}
	
	public ScHashArrayList(int capacity) {
		this.capacity = capacity;
		n = 0;
		this.hashTable = new ArrayList<>(this.capacity);
	}
	
	public Entry<K, V> get(K key){
		int i = this.findSlot(key);
		if (i >= 0) {
			return this.hashTable.get(i);		
		}
		return null; 
	}
	
	public V put(K key, V value) { //add new entry
		Entry<K, V> entry = new MapEntry<>(key, value);
		this.hashTable.add(entry);
		n++;
		return value;
	}
	
	public int size() {
		return this.n;
	}
	
	public V set(K key, V value) { //update
		
		int i = this.findSlot(key);
		if (i >= 0) {
			Entry<K, V> entry = new MapEntry<>(key, value);
			V oldValue = this.hashTable.get(i).getValue();
			this.hashTable.set(i, entry);
			return oldValue;
		}
		return null;
	}
	
	public V remove(K key) {
		int i = this.findSlot(key);
		if (i >= 0) {
			V oldValue = this.hashTable.get(i).getValue();
			this.hashTable.remove(i);
			n--;
			return oldValue;
		}
		return null;
	}
	
	private int findSlot(K key) {
		for (int i = 0; i < hashTable.size(); i++) {
			if (hashTable.get(i).getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}
}
