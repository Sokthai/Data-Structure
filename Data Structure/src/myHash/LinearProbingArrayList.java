package myHash;

public class LinearProbingArrayList<K, V> implements HashInterface<K, V>{ 
	
	private Entry<K, V>[] table;
	private int capacity;
	private final Entry<K, V> DEFUNCT = new MapEntry<>(null, null);
	private int n;
	
	public LinearProbingArrayList() {
		this(17);
		
	}
	
	public LinearProbingArrayList(int capacity) {
		this.capacity = capacity;
		this.n = 0;
		this.table = new Entry[this.capacity];
	}
	

	
	
	
	
	
	
	
	
	
	
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int size() {
		return this.n;
	}
	
	private int hashFunction(int k, int i) {
		// h(k, i) = (k + 1) % m;
		return k + 1 % this.capacity;
	}
	
	
	private int findAvailableSlot(int k, int i) {
		int index = this.hashFunction(k, i);
		Entry<K, V> temp = this.table[index];
		
		while(temp != null) {
			i++;
			temp = this.table[this.hashFunction(k, i)];
		}
		
		return index;
	}
	
	


	@Override
	public Entry<K, V> bucketGet(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V bucketPut(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V bucketRemove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V bucketSet(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashFunction(K key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
