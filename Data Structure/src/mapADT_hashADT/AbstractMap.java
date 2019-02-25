package mapADT_hashADT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import mapADT_hashADT.AbstractMap.MapEntry;

public abstract class AbstractMap<K, V> implements Map<K, V>{
	public boolean isEmpty(){
		return size() == 0; //call its Map's size() and compare
	}
	
	//============Nested MapEntry class ===============================================
		protected static class MapEntry<K, V> implements Entry<K, V>{
			private K k;
			private V v;
			public MapEntry(K key, V value){
				k = key;
				v = value;
			}
			
			public K getKey(){	return k; }
			public V getValue(){ return v; }
			
			protected void setKey(K key){ k = key;}
			protected V setValue(V value){
				V old = v;
				v = value;
				return old;
			}			
		}	
	//============Ended Nested class====================================================
	
		
	//Support for public key set method...
	private class KeyIterator implements Iterator<K>{
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); //reuse entrySet
		public boolean hasNext() { return entries.hasNext(); }
		public K next(){ return entries.next().getKey(); } // return key;
		public void remove(){ throw new UnsupportedOperationException(); }
	}
		
	private class KeyIterable implements Iterable<K>{
		public Iterator<K> iterator(){ return new KeyIterator(); }
	}
		
	public Iterable<K> keySet(){ return new KeyIterable(); } //return the iterable of all the key in M
		
	
	
	//Support for public value method...
	private class ValueIterator implements Iterator<V>{
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); //reuse entrySet
		public boolean hasNext() { return entries.hasNext(); }
		public V next(){ return entries.next().getValue(); } //return value;
		public void remove(){ throw new UnsupportedOperationException(); }
	}
		
	private class ValueIterable implements Iterable<V>{
		public Iterator<V> iterator() { return new ValueIterator(); }
	}
	
	public Iterable<V> values() { return new ValueIterable(); } //return the iterable of all the value in M
			
}
