package superAndSubClass;

public class SuperClass {
	private int width, height;
	
	public void setArea(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getArea(){
		return width * height;
	}
}
