package myHash;

public class SeparateChainingLinkList<K, V> extends AbstractHashMap<K, V>{
	private int capacity;
	private int prime;
	private ScHashLinkList<K, V>[] table;
	private int n;
	
	public SeparateChainingLinkList() {
		this(17);
	}
	
	public SeparateChainingLinkList(int capacity) {
		this(capacity, 109345121);

		this.capacity = capacity;
	}
	
	public SeparateChainingLinkList(int capacity, int prime) {
		super(capacity, prime);
		this.capacity = capacity;
		table = new ScHashLinkList[this.capacity];
		this.prime = prime;
		this.n = 0;
	}
	
	
	
	
	
	
	public int size() {
		return this.n;
	}
	
	
	
	
	
	@Override
	public Entry<K, V> bucketGet(K key) {
		int index = super.hashFunction(key);
		ScHashLinkList<K, V> sll = table[index];
		
		return sll.get(key);
	}
	
	
	
	
	

	@Override
	public V bucketPut(K key, V value) {
		int index = super.hashFunction(key);
		Entry<K, V> entry = new MapEntry<>(key, value);
		
		
		if (table[index] == null) {
			table[index] = new ScHashLinkList(entry);
		}else {
			table[index].addFrist(entry);
		}
		this.n++;
		return value;
	}

	@Override
	public V bucketRemove(K key) {
		
		int index = super.hashFunction(key);
		if (table[index] == null) {
			return null;
		}
		this.n--;

		return table[index].pop(key);

	}

	@Override
	public V bucketSet(K key, V value) {
		int index = super.hashFunction(key);		
		return (table[index] == null)? null : table[index].set(key, value);
	}
}
