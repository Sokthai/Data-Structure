import java.util.Scanner;

public class PizzaTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pizza p1;
        Pizza p2;

        System.out.println("What size pizza would you like?");
        System.out.println("small, medium, large");
        String size1 = scan.nextLine();

        System.out.println("How many meat toppings would you like");
        int meatNum1 = scan.nextInt();

        System.out.println("How many vegatable toppings would you like?");
        int vegNum1 = scan.nextInt();

        System.out.println("What size pizza would you like?");
        System.out.println("small, medium, large");
        String size2 = scan.nextLine();

        System.out.println("How many meat toppings would you like");
        int meatNum2 = scan.nextInt();

        System.out.println("How many vegatable toppings would you like?");
        int vegNum2 = scan.nextInt();

        p1 = new Pizza(size1, meatNum1, vegNum1);
        p2 = new Pizza(size2, meatNum2, vegNum2);
    }
}
