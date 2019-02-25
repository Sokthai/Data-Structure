import java.util.Arrays;
//Algorithm hw1 Sept/19/2018
public class mergeSort {
 int inversion = 0;
 public void merge_sort(int[] arr){
	 int n = arr.length;
	 int mid = n / 2;
	 
	 int[] arrLeft = Arrays.copyOfRange(arr, 0, mid); //copy to left array
	 int[] arrRight = Arrays.copyOfRange(arr, mid, n); //copy to right array
	 
	 merge_sort(arrLeft);
	 merge_sort(arrRight);
	 merge(arrLeft, arrRight);
 }
 
 public void merge(int[] arrLeft, int[] arrRight){
	 int n = arrLeft.length + arrRight.length;
	 int[] arr = new int[n];
	 int l = 0, r = 0, i = 0;
	 
	 while ((l + r) < n ){
		 if (r == arrRight.length || (l < arrLeft.length && (arrLeft[l] < arrRight[r])  )){
			 arr[i++] = arrLeft[l++];				 
		 }else{
			 inversion += arrLeft.length - l;
			 arr[i++] = arrRight[r++];
		 } 
	 }
	 
	 while (l < arrLeft.length){
		 arr[i++] = arrLeft[l++];
	 }
	 
	 while(r < arrRight.length){
		 arr[i++] = arrRight[r++];
	 }	 
 }
}
