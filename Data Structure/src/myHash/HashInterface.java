package myHash;

public interface HashInterface<K, V> {
	int hashFunction(K key);
	Entry<K,V> bucketGet(K key);
	V bucketPut(K key, V value); //adding new item and return the newly added value;
	V bucketRemove( K key);//return the removed value;
	V bucketSet(K key, V value);//update and return the old value;
	
}
