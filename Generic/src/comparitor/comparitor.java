package comparitor;
import java.util.Comparator;

public class comparitor<E> implements Comparator<E>{
	
	
	public int compare(E a, E b){
		if (a == b) {
			return (Integer)a;
		}
		return (Integer)b;
	}
	
	
	public static void main(String[] args){
		comparitor<Integer> c = new comparitor<>();
		System.out.println (c.compare(new Integer(97), new Integer(90)));
	}

}
