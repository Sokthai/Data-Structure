package priorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>{
	protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
	
	
	public HeapPriorityQueue(){ 
		super();
	}
	
	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}
	
	//Truncating division
	protected int parent(int j){ //mean to find J's parent
		return (j - 1) / 2; //minus 1 because we want to eliminate one child, divide by 2 because a parent has 2 children
	}
	
	protected int left(int j){ //mean to find J's left child
		return 2 * j + 1; //time 2 because a parent has 2 children, and plus 1 because it is the left
	}
	
	protected int right(int j){ //mean to find J's right child
		return 2 * j + 2; //time 2 because a parent has 2 children, and plus 2 because it is the right
	}
	
	protected boolean hasLeft(int j){
		return left(j) < heap.size();
	}
	
	protected boolean hasRight(int j){
		return right(j) < heap.size();
	}

	protected void swap(int i, int j){
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	protected void upHeap(int j){ //for adding (bottom - up)
		while (j > 0){
			int p = parent(j);//get it parent
			if (compare(heap.get(j), heap.get(p)) >= 0) //if child is already >= to its parent, just break out
				break;
			swap(j, p);
			j = p;
		}
	}
	
	protected void downHeap(int j){ //for removal (up - down)
		while (hasLeft(j)){
			int leftIndex = left(j);
			int smallChildIndex = leftIndex;
			
			if (hasRight(j)){
				int rightIndex = right(j);
				if (compare(heap.get(leftIndex),heap.get(rightIndex)) > 0){ //if (leftIndex > rightIndex)
					smallChildIndex = rightIndex;
				}
			}
			
			if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) //if the child is already greater than the parent, do nothing, break out
				break;
			
			swap(j, smallChildIndex);
			j = smallChildIndex;
		}
	}

	public int size(){
		return heap.size();
	}
	
	public Entry<K, V> min(){
		if (heap.isEmpty()) return null;
		return heap.get(0); //in the heap structure, the root is either the smallest or the largest, depend on how we want to defind it. 
							//in this program, the root is the smallest;			
	}
	
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		heap.add(newest);
		upHeap(heap.size() - 1);
		return newest;
	}
	
	public Entry<K, V> removeMin(){
		if (heap.isEmpty()) return null;
		Entry<K, V> answer = heap.get(0);
		swap(0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		heap.remove(0);
		downHeap(0);
		return answer;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//=============Bottom-up Heap construction=======================
	//start adding the last level of entry (n+1)/2^i where  2 <= i <= h; h = floor(log n))
	//then do the DOWN HEAP Bubbling.
	
	public HeapPriorityQueue(K[] key, V[] value){ //we use the array K[] and V[], because we assuming we do know all the value in advance, that is what we call Bottom-up Construction
		super();
		for (int j = 0; j < Math.min(key.length, value.length); j++){
			Entry<K, V> newest = new PQEntry<>(key[j], value[j]);
			heap.add(newest);
			heapify();
		}
	}
	
	protected void heapify(){
		int startIndex = parent(size() -1);
		for (int j = startIndex; j >= 0; j--){
			downHeap(j);
		}
	}
	
	
	//========sorting with Priority Queue=============
	public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E, ?> P){
		int n = S.size();
		for (int j = 0; j < n; j++){
			E element  = S.remove(S.first());
			P.insert(element, null);
		}
		
		for (int j = 0; j < n; j++){
			E element = P.removeMin().getKey();
			S.addLast(element);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	//============main class====================
	
	public static void main(String[] args){
		
		LinkedPostionalList<Integer> pos = new LinkedPostionalList<>();
		PriorityQueue<Integer, String> pqueue = new SortedPriorityQueue<>();		
		
		
		
		
		p.println("this is Heap");
		
		pos.addFirst(new Integer (333));
		pos.addFirst(new Integer (111));
		pos.addFirst(new Integer (222));
//		pos.addFirst(new Integer (444));
//		pos.addFirst(new Integer (555));
//		pos.addFirst(new Integer (666));
//		pos.addFirst(new Integer (777));
//		pos.addFirst(new Integer (888));
//		pos.addFirst(new Integer (999));
		
		
		HeapPriorityQueue.pqSort(pos, pqueue);
		

		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
