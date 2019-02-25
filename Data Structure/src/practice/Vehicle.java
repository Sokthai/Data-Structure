package practice;

public class Vehicle {
	private String theVIN;
    private String theMake;  
    protected int numWheels=4;
    
    public Vehicle (String VIN, String Make){
    		theVIN = VIN; theMake = Make;
    		}
    public String toString() {
    	return "VIN: "+theVIN+". Make: "+theMake+".";
    	}
    public void testing(){
    	
    }
}
