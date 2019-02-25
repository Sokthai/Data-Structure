package practice;

public class Motorcycle extends Vehicle {
	private int power;
	public Motorcycle(String vin, String make, int power){
		super(vin, make);
		this.power = power;
	}
	
	public String toString(){
		return super.toString() + " A " + power + " cc motorcycle.";
	}
}
