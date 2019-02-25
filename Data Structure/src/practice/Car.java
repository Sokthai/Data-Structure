package practice;

public class Car extends Vehicle {
	private String color;
	public Car(String VIN, String make, String color){
		
		super(VIN, make);
		
		this.color = color;
	}
	
	
	public String toString(){
		return super.toString() + " A " + color + " car.";
		
	}

}
