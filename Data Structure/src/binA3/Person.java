package binA3;



public class Person {
	 static int IDgenerator = 1;
	    private String name;
	    private int ID;
	    public Person (String sName) {        
	        setName(sName); ID=IDgenerator++;}
	    public int getID(){return ID;}
	    public String getName(){ return name;}
	    
	    

	    public void setName(String sName) {name = sName;}

	    public String toString (){ return "[" + name + " " + ID + "]";}
	    
	    // two Person objects are considered equal if their ID's are equal
	    public Boolean equals(Person p){ return ID==p.getID(); }
}
