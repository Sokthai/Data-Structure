package superAndSubClass;

public class SubClass extends SuperClass{
	public String displaySub(){
		return String.format("this is a test");
	}
	
	public String displaySubWithSuperClass(){
		return String.format("this is the intergration betweeen sub and super%f", super.getArea());
	}
}
