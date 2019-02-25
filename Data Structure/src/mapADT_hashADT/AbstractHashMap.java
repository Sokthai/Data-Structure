package mapADT_hashADT;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V>{
	protected int n = 0; //n is the load factor. Lamda symbol representation. 
	protected int capacity;
	private int prime;
	private long scale, shift;
	
	public AbstractHashMap(int cap, int p){
		prime = p;
		capacity = cap;
		Random rand = new Random();
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}
	
	public AbstractHashMap(int cap){
		this(cap, 109345121); //capacity with default prime number
	}
	public AbstractHashMap(){
		this(17); //good to have Prime Array's size. reduce repetition
	}
	
	public int size(){ return n;}
	public V get(K key){
		return bucketGet(hashValue(key), key);
	}
	
	public V remove(K key){
		return bucketRemove(hashValue(key), key);
	}
	public V put(K key, V value){
		V answer = bucketPut(hashValue(key), key, value);
		if (n > capacity / 2) //keep load factor <= 0.5 or 50%
			resize(2 * capacity - 1);
		return answer;
	}
	
	
	
	private int hashValue(K key){ //h(key) = [(a(key)+b) % p] % N; //Hash function formula
		
		return (int)(Math.abs((key.hashCode() * scale + shift) % prime) % capacity); //hash function
		// where a = scale.  b = shift. p = prime. N = capacity
		// "N" is array's size. "p" is prime number with "p" is greater than "N"
		// "a" and "b" are random number with "a" greater than zero(0)
		// "key" is the key that user passes in.
	}
	
	private void resize(int newCap){ // if the size of array is full or reach the condition, resize (double the old one)
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(newCap);
		for(Entry<K, V> e : entrySet()) 
			buffer.add(e);
		capacity = newCap;
		createTable(); //based on updated capacity , and it will be recomputed while reinserting entries
		n = 0; 
		for(Entry<K, V> e : buffer)
			put(e.getKey(), e.getValue());
		
	}
	
	
	//to be implemented in subclasses;
	protected abstract void createTable();
	protected abstract V bucketGet(int h, K k);
	protected abstract V bucketPut(int h, K k, V v);
	protected abstract V bucketRemove(int h, K k);
	
	
}
