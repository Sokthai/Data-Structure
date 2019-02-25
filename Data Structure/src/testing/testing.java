package testing;

public class testing {
	public static void main(String[] args){
		System.out.println(test(5));
	}
	
	
	
	private static String test(int i){
		for (int j = 0; j <= 1; j++){
			if (i > j)
				return "i is zero";
			if (i > j)
				return "i is also one";
		}
		
		return "";
	}
}
