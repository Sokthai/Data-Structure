package superAndSubClass;

public class ExtendedInterface implements MyInterface{
	private String msg;
	public void setMessage(String msg){
		this.msg = msg;
	}
	
	public String getMessage(){
		return this.msg;
	}
	
	public String displayFromExtendedClass(){
		return String.format("this is the message from class implemented interface");
	}
}
