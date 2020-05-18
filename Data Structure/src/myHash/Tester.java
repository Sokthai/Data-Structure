package myHash;

import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.LocalDateTime;  

public class Tester {
	//May-17-2020
    public static void main(String[] args){
		SeparateChaining<String, String> sc = new SeparateChaining<>(500);
		
		for (int i = 0 ; i < 600; i++) {
			sc.bucketPut("key" + i, "this is key " + i + " value");
		}
		
		
		
		
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
			System.out.println(java.time.LocalTime.now());
			
			Print.println(sc.bucketSet("key1", "key1 is updated"));
			Print.println(sc.bucketGet("key1").getValue());
			System.out.println(java.time.LocalTime.now());
			
			int k[] = new int[600];
			
			for (int j = 0; j < 600; j++) {
				k[j] = j;
			}
			
			System.out.println(java.time.LocalTime.now());

			
			sc.bucketRemove("key1");
//			Print.println(sc.bucketGet("key1").getValue());

			
			Print.println(sc.size());
		}catch (NullPointerException e) {
			System.err.print(e.getMessage());
		}
		
	
	}
}
