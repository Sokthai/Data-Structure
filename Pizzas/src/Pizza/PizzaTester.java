package Pizza;

import java.util.Scanner;

public class PizzaTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pizza pizza[] = new Pizza[2];
        
        for (int i = 0; i < 2; i++){
	        System.out.println("What size pizza would you like?");
	        System.out.println("small, medium, large");
	        String size1 = scan.nextLine();
	
	        System.out.println("How many meat toppings would you like");
	        int meatNum1 = scan.nextInt();
	
	        System.out.println("How many vegatable toppings would you like?");
	        int vegNum1 = scan.nextInt();
	        pizza[i] = new Pizza(size1, meatNum1, vegNum1);
        }

        
        System.out.print(pizza[0].toString());


    }
}
