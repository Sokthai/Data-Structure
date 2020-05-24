package myHash;

public class SeparateChaining<K, V> extends AbstractHashMap<K, V>{
	
	private int prime;
	private int capacity;
	private ScHashArrayList<K, V> table[];
	private int n;
	
	public SeparateChaining(int capacity, int prime)   throws NullPointerException{
		super(capacity, prime);
		this.table = new ScHashArrayList[capacity];
		this.n = 0;
	}
	//separate chaining method
	public SeparateChaining(int capacity) {
		this(capacity, 109345121);
	}
	
	public SeparateChaining() {
		this(17);
	}

	

	@Override
	public Entry<K, V> bucketGet(K key){ 
		int h = super.hashFunction(key);
		ScHashArrayList<K, V> chainTable = this.table[h];
		if (chainTable != null) {
			return chainTable.get(key);
		}
		return null;
	}

	@Override
	public V bucketPut(K key, V value) { //add new
		int h = super.hashFunction(key);
		ScHashArrayList<K, V> entry = this.table[h];
		
		if (entry == null) {
			ScHashArrayList<K, V> chainTable = new ScHashArrayList<>();
			chainTable.put(key, value);
			this.table[h] = chainTable;
		}else {
			entry.put(key, value);
		}
		this.n++;
		return value;
	}

	@Override
	public V bucketRemove( K key) {
		int h = super.hashFunction(key);
		
		ScHashArrayList<K, V> chainTable = this.table[h];
		
		if (chainTable != null) {
			V oldValue = chainTable.remove(key);
			this.n = (oldValue == null)? this.n : this.n - 1 ;
			return oldValue;
		}
		
		return null;
	}

	@Override
	public V bucketSet(K key, V value) {
		int h = super.hashFunction(key);
		ScHashArrayList<K, V> chainTable = this.table[h];
		if (chainTable != null) {
			return chainTable.set(key, value);
		}
		return null;
	}

	public int size() {
		return this.n;
	}
	
}
 