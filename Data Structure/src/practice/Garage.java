package practice;
import java.util.List;


import java.util.ArrayList;

public class Garage<T extends Vehicle> {
	
	List<T> vehicle = new ArrayList<>();
//	private Garage<T> n;
	
	public void parkIt(T type){
		vehicle.add(type);
	}
	
	public int Count(){
		return vehicle.size();
	}
	
	public String toString(){
		String msg = "";
		for (T m: vehicle){
			
			msg += String.format("%s%n", m.toString());
		}
		
		return msg;
	}
}
