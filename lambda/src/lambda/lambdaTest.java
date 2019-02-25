package lambda;
import java.util.stream.IntStream;




public class lambdaTest {

	public static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		IntStream.of(values).forEach( value -> System.out.printf("%d " , value));
		System.out.println();
		IntStream.of(values).filter(value -> value % 2 == 0).forEach(value -> System.out.println(value));
		
		
		System.out.println(IntStream.of(values).sum());
		
		IntStream.of(values).filter(value -> value % 2 == 1).reduce(0, (x , y) -> {return x + y;});
	}

}


