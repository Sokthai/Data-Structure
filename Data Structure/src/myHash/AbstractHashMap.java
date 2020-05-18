package myHash;

import java.util.Random;

public abstract class AbstractHashMap<K, V> implements HashInterface<K, V> {

	private int scale ;
	private int shift;
	private int prime; 
	private int capacity;
	public AbstractHashMap() {
		this(17);
	}
	
	public AbstractHashMap(int capacity) {
		this(capacity, 109345121);
	}
	
	
	public AbstractHashMap(int capacity, int prime) {
		this.capacity = capacity;
		this.prime = prime;
		Random rand = new Random();
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
	}
	

	
	
	
	
	
	
	
	public int hashFunction(K key) {
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
	}

	
	
	
	
}
