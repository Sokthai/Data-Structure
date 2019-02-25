package Assignment4;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JColorChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class A4 extends JPanel{
    private final JButton btnColorPicker;
    private final JCheckBox chkFilled;
    private final JComboBox cmbShapes;
    private final String[] items = {"Rectangle", "Square", "Oval", "Circle", "Line", "Rounded Rectangle"};
    private final JPanel panel;
    private Color color = Color.GRAY;
    private Boolean filled = true;
    private String shape = "Rectangle";
    private int[] x = {100, 300}; //set all default coordinates
    private int[] y = {100, 150};
    int x0 = 100, y0 = 100, x1 = 400, y1 = 250, i = 150, j = 100, s = 200;
    
    public A4(){ 
        super.setLayout(new BorderLayout()); 
        btnColorPicker = new JButton("Pick a color"); //create all components
        chkFilled = new JCheckBox("Filled", true);
        cmbShapes = new JComboBox(items);
        
        //register ActionListener to button
        btnColorPicker.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                 color = JColorChooser.showDialog(null, "Choose a color",  color);                
                 repaint();
            }
        });
        
        //add item listener to checkbox
        chkFilled.addItemListener(new ItemListener(){  
             public void itemStateChanged(ItemEvent event){
                 if (chkFilled.isSelected() == true)
                     filled = true;
                 else
                     filled = false; 
                repaint();
             }
        });
        
        //add item listener to dropdown
        cmbShapes.addItemListener(new ItemListener(){  
            public void itemStateChanged(ItemEvent event){
                 shape = cmbShapes.getSelectedItem().toString();          
                 repaint();
                 
               
            }
        });
        mouse mouse = new mouse();
        mouseMotion mouseMotion = new mouseMotion();
        panel = new JPanel(); 
        panel.add(cmbShapes);//add all components
        panel.add(btnColorPicker);
        panel.add(chkFilled);
        super.addMouseListener(mouse); //register all event to super
        super.addMouseMotionListener(mouseMotion);
        super.setBackground(Color.BLACK);
        add(panel, BorderLayout.SOUTH);
        repaint();       
    }

    public void paintComponent(Graphics g){ //graphic method
        super.paintComponent(g);
        g.setColor(color);
       
        
        switch (shape){
        case "Rectangle": //draw rectangle
            g.drawRect(x[0], y[0], x[1], y[1]);
            if (filled == true)
                g.fillRect(x[0], y[0], x[1], y[1]);
            break;
        case "Square": //draw square              
          g.drawRect( i, j, s, s); //make is always square for all directions
            if (filled == true)
                g.fillRect(i, j, s, s);
            break;
        case "Oval"://draw oval
            g.drawOval(x[0], y[0], x[1] , y[1]);
            if (filled == true)
                g.fillOval(x[0], y[0], x[1] , y[1]);
            break;
        case "Circle": //draw circle
            g.drawArc(i, j, s, s, 0, 360); //make is always circle for all directions
            if (filled == true)
                g.fillArc(i, j, s, s, 0, 360);
            break;
            
        case "Line"://draw line
            g.drawLine(x0, y0, x1, y1);
            break;
            
        case "Rounded Rectangle"://draw rounded rectangle
            g.drawRoundRect(x[0], y[0], x[1], y[1], 30, 30);
            if (filled == true)
                g.fillRoundRect(x[0], y[0], x[1], y[1], 30, 30);
            
        }      
    }
   
    private class mouse extends MouseAdapter{
        // add mouse pressed event
        public void mousePressed(MouseEvent event){ 
            x[0] = event.getX();
            y[0] = event.getY();  
            x0 = x[0]; y0 = y[0];
            
        }
        // add the mouse release event
        public void mouseReleased(MouseEvent event){ 
            x[1] = event.getX();
            y[1] = event.getY();
            x1= x[1]; y1 = y[1];
            setCoordinate();
            repaint();
        }
    }
    
    // add mouse motion listener
    private class mouseMotion extends MouseMotionAdapter{ 
        public void mouseDragged(MouseEvent event){
           x[1] = event.getX();
           y[1] = event.getY();
           x1= x[1]; y1 = y[1];
           setCoordinate();
           repaint();
        }
    }
    
    //set the coordinate all of direction
    private void setCoordinate(){         
                int a = 0, b = 0;
                if (x0 <= x[1] && y0 <= y[1]){
                    x[1] = x[1] - x0;
                    y[1] = y[1] - y0;
                    x[0] = x0; y[0] = y0;
                    s = (x[1] + y[1]) / 2;
                    i = x0; j = y0;
                }else if (x0 >= x[1] && y0 >= y[1]){                    
                    a = x0 - x[1];
                    b = y0 - y[1];
                    x[0] = x[1];
                    y[0] = y[1];
                    x[1] = a; y[1] = b;
                    s = (x[1] + y[1]) / 2;
                    i = x0 - s; j = y0 - s;  
                }else if(x0 <= x[1] && y0 >= y[1]){
                    a = x[1] - x0;
                    b = y0 - y[1];
                    x[0] = x0;
                    y[0] = y[1];
                    x[1] = a; y[1] = b;
                    s = (x[1] + y[1]) / 2;
                    i = x0; j = y0 - s;
                }else if (x0 >= x[1] && y0 <= y[1]){
                    a = x0 - x[1];
                    b = y[1] - y0;
                    x[0] = x[1];
                    y[0] = y0;
                    x[1] = a; y[1] = b;
                    s = (x[1] + y[1]) / 2;
                    i = x0 - s; j = y0;
                }
    } 
}