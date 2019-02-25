package superAndSubClass;

public class Testing {
	public static void main(String[] args){
		SubClass sub = new SubClass(); //normal
		SuperClass sup = new SuperClass(); //normal
		
		SuperClass SupSub = new SubClass(); //can only use the super class method
		
		
		ExtendedInterface exInterface = new ExtendedInterface();
		MyInterface interf = new ExtendedInterface();
		
		
		
		
		
	}
}
