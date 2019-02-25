package practice;

public class Parking {
	public static void main(String[] args) {

        Garage <Car> cargarage = new Garage<>(); 
        Garage <Motorcycle> motorcyclegarage = new Garage<>();
        
        Car c1 = new Car("V1111", "Toyota", "Blue");
        Car c2 = new Car("V2222", "Ford", "Red");
        Motorcycle m1 = new Motorcycle("V5555","Harley Davidson", 600);
        Motorcycle m2 = new Motorcycle("V6666","Indian", 1200); 
        
        cargarage.parkIt(c1);
        cargarage.parkIt(c2);
        
        motorcyclegarage.parkIt(m1);        
        motorcyclegarage.parkIt(m2);
                
        System.out.println (cargarage);
        
        System.out.println (motorcyclegarage);
        
        


        
    }
}
