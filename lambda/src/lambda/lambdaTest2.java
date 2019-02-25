package lambda;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class lambdaTest2 {

	public static void main(String[] args) {
		Integer[] values = {1,2,3,4,5,6,7,8,9};
		Integer[] ok = {1,2 ,3, 4, 5};
 		System.out.printf("Original values: %s%n ", Arrays.asList(values));
 		
 		System.out.printf("Sorted values %s%n", Arrays.stream(values).sorted().collect(Collectors.toList()));

	}

}
