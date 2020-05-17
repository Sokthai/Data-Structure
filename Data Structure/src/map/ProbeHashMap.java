package map;

import java.util.ArrayList;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
	ArrayList<MapEntry<K, V>> table;
	MapEntry<K, V> DEFUNCT = new MapEntry<K, V>(null, null);
	
	public ProbeHashMap() {
		super();
	}
	
	public ProbeHashMap(int capacity) {
		super(capacity);
	}
	
	public ProbeHashMap(int capacity, int prime) {
		super(capacity, prime);
	}
	
	
	

	
	
	
	
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		// TODO Auto-generated method stub
		this.table = new ArrayList<MapEntry<K, V>>(capacity);
		
	}

	
	private int findSlotAll(int h, K k) {
		int index = -1;
		int j = h;
		while(true) {
			if (table.get(j) == null) {
				if (h != j ) {
					index = j;
				}
					break;
			}else if (this.isAvailable(table.get(j))) {
				if (this.table.get(j).getKey().equals(k)) {
					index = j;break;
				}
			}
			
			j = h + 1 % this.table.size();
		}
		
		return index;
	}
	
	
	
	
	@Override
	protected V bucketGet(int h, K k) {
		if (this.table.get(h) == null) {
			return null;
		}
		
		for(int i = h; h < table.size(); h++) {
			if (this.table.get(i).getKey() == k) {
				return table.get(i).getValue();
			}else if (this.table.get(i) == null) {
				break;
			}
		}
		return null;
	}
	
	
	
	private boolean isAvailable(MapEntry<K, V> entry) {
		return entry == null || entry == DEFUNCT;
	}
	
	
	private int findSlot(int h) {
		if (this.table.get(h) == null) {
			return -1;
		}
		int i = 1;
		while (true) {
			h = h + i % this.table.size();
			if (this.isAvailable(this.table.get(i))) {
				break;
			}
			i++;
		}
		
		return h;
		
	}
	
	
	
	
	

	@Override
	protected V bucketPut(int h, K k, V v) {
		MapEntry<K, V> entry = new MapEntry<K, V>(k, v);
		this.table.set(this.findSlot(h), entry);
		return v;
	}

	@Override
	protected V bucketRemove(int h, K k) {
		V value;
		if (this.table.get(h) == null) {
			return null;
		}
		
		for (int i = h; h < this.table.size(); i++) {
			if (this.table.get(i).getKey() == k) {
				n--;
				value = this.table.get(i).getValue();
				this.table.set(i, DEFUNCT);
				return value;
			}else if (this.table.get(i) == null) {
				break;
			}
			
		}
		
		return null;
	}
	
	
	
	
}

	
