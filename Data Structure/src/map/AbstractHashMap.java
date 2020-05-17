package map;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K, V> {
	protected int n = 0;
	protected int capacity; //size of array is good to be prime to reduce collision
	private int prime; //prime factor
	private long scale, shift; //the shift scaling factor . 'needed when the array close or full
	private double loadFactor;
	
	public AbstractHashMap(int capacity, int prime) {
		this.prime = prime;
		this.capacity = capacity;
		Random rand = new Random();
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}
	
	public AbstractHashMap(int capacity) {
		this(capacity, 109345121);//default prime
	}
	
	public AbstractHashMap() {
		this(17); //default capacity
	}
	
	
	
	public int size() {
		return n;
	}
	
	public V get(K key) {
		return bucketGet(hashValue(key), key);
	}
	
	public V remove(K key) {
		return bucketRemove(hashValue(key), key);
	}
	
	public V put(K key, V value) {
		V answer = bucketPut(hashValue(key), key , value);
		this.loadFactor = this.capacity / 2; //keep capacity 50%
		if (n > loadFactor) {
			resize(2 * capacity - 1);
		}
		return answer;
	}
	
	
	//hash function
	private int hashValue(K key) { //this is hash function. good hash function will try to distribute the evenly and reduce collision
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
	}
	
	private void resize (int newCapacity) {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(newCapacity);
		for (Entry<K, V> e: entrySet()) {
			buffer.add(e);
		}
		
		capacity = newCapacity;
		createTable(); //based on updated capacity, it will be recomputed while reinserting entries
		n = 0;
		for (Entry<K, V> e : buffer) {
			put(e.getKey(), e.getValue());
		}
		
	}
	
	
	protected abstract void createTable();
	protected abstract V bucketGet(int h, K k);
	protected abstract V bucketPut(int h, K k, V v);
	protected abstract V bucketRemove(int h, K k);
	
}
