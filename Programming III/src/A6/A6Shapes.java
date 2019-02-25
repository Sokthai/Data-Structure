package A6;
import java.awt.Color;

public class A6Shapes{ //this object will store the the old shapes that previously drawn
  
    private String shapes; //store the shapes
    private boolean filled; //store if it is filled
    private Color color;
    private int x1, y1, x2, y2; //store the x and y coordinate

    public A6Shapes(String shapes, int x1, int y1,int x2, int y2, Color color, boolean filled){
        this.shapes = shapes;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.filled = filled;
        this.color = color;
    }
    
    public int getX1(){ //return x1
        return this.x1;       
    }
    
    public int getY1(){ //return y1
        return this.y1;
    }
    public int getX2(){ //return x2
        return this.x2;
    }
    public int getY2(){ //return y2
        return this.y2;
    }
    
    public void setFilled(boolean filled){ //change if filled
        this.filled = filled;
    }
    
    public void setColor(Color color){ //change color
        this.color = color;
    }
    
    public boolean getFilled(){ //return filled
        return this.filled;
    }
    public Color getColor(){ //get color
        return this.color;
    }
    
    public String getShape(){ //get shape
        return this.shapes;
    }
    
    public String toString(){
        return String.format("x1 %d y1 %d x2 %d y2 %d filled %s Color %s shapes %s %n", 
                this.x1, this.y1, this.x2, this.y2, filled, color, shapes);
    }
}