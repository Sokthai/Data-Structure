package myHash;

public class MapEntry<K, V> implements Entry<K, V> {
	private K key; 
	private V value;
	
	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	
	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	@Override
	public void setValue(V value) {
		this.value = value;
	}
	
}
