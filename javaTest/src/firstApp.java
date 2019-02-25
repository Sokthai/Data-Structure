import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class firstApp {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
	
	 static int diagonalDifference(int[][] a) {
	       int l = a.length;
	       int r1 = 0, r2 = 0;
	       for (int i = 0; i < l; i++){
	    	   r1 += a[i][i];
	    	   r2 += a[i][(l - 1) - i];
	       }
	       System.out.printf("%d %d \n ", r1, r2 );
	       return Math.abs(r1 - r2);
	       
	       
	    }
	
}
