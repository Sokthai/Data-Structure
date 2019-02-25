package mapADT_hashADT;

import java.util.ArrayList;

//Open Addressing , Linear Probe (Hash)
public class ProbeHashMap<K, V> extends AbstractHashMap<K, V>{
	private MapEntry<K, V>[] table; //a fixed array of entries with all initially null
	private final MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);  //Sentinel
	
	public ProbeHashMap(){ super(); }
	public ProbeHashMap(int cap){ super(cap);}
	public ProbeHashMap(int cap, int p){ super(cap, p); }
	
	protected void createTable(){
		table = (MapEntry<K, V>[]) new MapEntry[capacity]; //safe cast
	}
	
	private boolean isAvailable (int j){
		return (table[j] == null || table[j] == DEFUNCT);
	}
	
	
	//return index with key k, or -(a+1) such that k could be added at index a.
	private int findSlot(int h, K k){
		
		int avail = -1;
		int j = h;
		
		
		do{
			if (isAvailable(j)){ //either empty or DEFUNCT
				if (avail == -1) avail = j; //first available slot
				if (table[j] == null) break; //if empty, search fails immediately
			}else if(table[j].getKey().equals(k)){ 
				return j;		//successful match
			}
			j = (j + 1) % capacity; //keep looking cyclically
		}while(j != h); //stop if we return to the start
		return -(avail + 1); //search has failed
		
		
		
//		do {
//		
//			if (isAvailable(j)){
//				avail = j;
//			}else{
//				j = (j + 1) % capacity;
//			}	
//		}while(avail != -1);
//		
//		return avail;
	}
	
	
	
	protected V bucketGet(int h, K k){
		int j = findSlot(h, k);
		if (j < 0) return null;
		return table[j].getValue();
	}
	
	protected V bucketPut(int h, K k, V v){
		int j = findSlot(h, k);
		if (j >= 0)
			return table[j].setValue(v);
		table[-(j+1)] = new MapEntry<>(k, v);
		n++;
		return null;
		
	}
	
	protected V bucketRemove(int h, K k){
		int j = findSlot(h, k);
		if(j < 0) return null; // nothing to remove
		V answer = table[j].getValue();
		table[j] = DEFUNCT; //make this slot deactivated 
		n--;
		return answer;
	}
	
	public Iterable<Entry<K, V>> entrySet(){
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for(int h = 0; h < capacity; h++)
			if (!isAvailable(h)) buffer.add(table[h]);
		return buffer;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

