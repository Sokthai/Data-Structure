package mergeSort;

public class MergeSort2 {
	private static int[] mergeSort(int[] a){
//		if (a.length == 1) return a;
		int[] list1 = new int[a.length / 2];
		int[] list2 = new int[a.length - list1.length];
		int l = a.length / 2, j = 0;
		int h = l + 1;
		System.out.println("this is l " + a.length);
		for (int i = 0; i < l; i++){
			list1[i] = a[i];
//			System.out.print(list1[i]);
		}
//		System.out.println("");
		for (int i = h - 1; i < a.length; i++){
			list2[j++] = a[i];
//			System.out.print(a[i]);
		}
		
		
		return merge(list1, list2);
		
		
		
		
		
//		System.arraycopy(a, 0, list1 , 0, list1.length);
//		System.arraycopy(a, (a.length / 2), list2 , 0, list2.length);
//		
//		for (int i = 0; i < list1.length; i++)
//			System.out.print(list1[i]);
//		System.out.println("");
//		for (int i = 0; i < list2.length; i++)
//			System.out.print(list2[i]);
		
	}
	
	
	
	private static int[] merge(int[] a, int[] b){
		int[] c = new int[a.length + b.length];
		int x = c.length - 1;
		while(a.length > 0 && b.length > 0){
			if (a[0] > b[0]){
				c[x--] = b[0];
				int[] temp = new int[b.length - 1];
				for (int j = 0; j < temp.length; j++)
					temp[j] = b[j + 1];
				b = temp;
				
			}else{
				c[x--] = a[0];
				int[] temp = new int[a.length - 1];
				for (int j = 0; j < temp.length; j++)
					temp[j] = a[j + 1];
				a = temp;
			}
				
		}
		
		while (a.length > 0){
			c[x--] = a[0];
			int[] temp = new int[a.length - 1];
			for (int j = 0; j < temp.length; j++)
				temp[j] = a[j + 1];
			a = temp;
		}
		
		while (b.length > 0){
			c[x--] = b[0];
			int[] temp = new int[b.length - 1];
			for (int j = 0; j < temp.length; j++)
				temp[j] = b[j + 1];
			b = temp;
		}
		
		return c;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		int[] test = {3, 1, 5, 2, 8, 6, 0, 7, 4, 0};
		int[] sorted = mergeSort(test);
		for (int i = 0; i < sorted.length; i++)
			System.out.print(sorted[i]);
		
	}
}
