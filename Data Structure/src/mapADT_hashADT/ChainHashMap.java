package mapADT_hashADT;

import java.util.ArrayList;


/**
 * SEPARATE CHAINGING. 
 * @author Allen 
 *	MAY-15-2016
 * @param <K>
 * @param <V>
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V>{
	
	private UnsortedTableMap<K, V>[] table; //initialized within create table;
	
	public ChainHashMap(){super();}
	public ChainHashMap(int cap){ super(cap); }
	public ChainHashMap(int cap, int p){ super(cap, p);}
	
	//create an empty table having length equal to current capacity
	protected void createTable(){
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
	}
	
	//return values associated with key k in bucket with hash value h or else null;
	protected V bucketGet(int h, K k){
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		
		return bucket.get(k);
	}
	
	protected V bucketPut(int h, K k, V v){ //getting the bucket (sub array)
		UnsortedTableMap<K, V> bucket = table[h]; //getting the subarray (or the list of the collision one)
		if (bucket == null)
			bucket = table[h] = new UnsortedTableMap<>(); //create new UnsortedTableMap<> for both "bucket" and "table[h]"
		int oldSize = bucket.size();
		V answer = bucket.put(k, v);
		n += (bucket.size() - oldSize);
		return answer;
	}
	
	protected V bucketRemove(int h, K k){
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		int oldSize = bucket.size();
		V answer = bucket.remove(k);
		n -= (oldSize - bucket.size());
		return answer;
	}
	
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList <Entry<K, V>> buffer = new ArrayList<>();
		for (int h = 0; h < capacity; h++)//loop the hash table (main array)
			if (table[h] != null)
				for (Entry<K, V> entry : table[h].entrySet()) //loop the list (sub array)
					buffer.add(entry);
		return buffer;
	}

	
}
