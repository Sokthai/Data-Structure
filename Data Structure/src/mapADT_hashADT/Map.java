package mapADT_hashADT;

public interface Map<K, V> { //Map class page 403
	int size(); //return the number of Entries in M
	boolean isEmpty(); //return boolean if M is empty
	V get(K key); //Return the value V associated with key k, if such an entry exists; otherwise return null;
	V put (K key, V value); //if M doesn't have entry with the key equal to k, then adds Entry<K, V> to M and return null;
							//else, replace V and return old V
	V remove(K key); //remove Entry<K, V> from M with key equal to k, or return null
	Iterable<K> keySet(); // returns an iterable collection containing all the keys stored in M
	Iterable<V> values(); //returns an iterable collection containing all the values of Entries store in M;
						//(with Repetition if multiple keys map to the same value)
	Iterable<Entry<K, V>> entrySet(); //return an iterable collection containing all the key-value entries in M.
}
