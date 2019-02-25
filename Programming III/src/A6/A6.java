package A6;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Graphics;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;


import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;





public class A6 extends JFrame{
    
    private final JMenuBar menuBar;
    private final JMenu menuFile, menuWindow;
    private final JMenuItem menuItemNew, menuItemExit;
    private JMenuItem menuItemWindow;
    private ArrayList<String> index; //index ArrayList
    private ArrayList<JInternalFrame> internalFrame; //internalFrame ArrayList
    private final JDesktopPane desktopPane;
    private int i = 0;
    private Dimension dim = new Dimension(400, 550); //create default dimension
    
    
    
    public A6(){
        index = new ArrayList<String>(); //create Index arrayList 
        internalFrame = new ArrayList<JInternalFrame>(); //create internalFrame arrayList
        menuBar = new JMenuBar(); //create JMenuBar
        menuFile = new JMenu("File");
        menuFile.setMnemonic('F');
        menuFile.add(menuItemNew = new JMenuItem("New")); //create JMenuFile
        menuFile.add(menuItemExit = new JMenuItem("Exit"));
        menuItemExit.setMnemonic('E'); 
        menuItemNew.setMnemonic('N');
        menuWindow = new JMenu("Window");
        menuWindow.setMnemonic('W');
        menuBar.add(menuFile);
        menuBar.add(menuWindow);
        setJMenuBar(menuBar); //set the JMenubar
        
        desktopPane = new JDesktopPane(); //create desktopPane
        add(desktopPane);
        
       
        
        menuItemNew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){      
                i++;
                index.add("Picture" + i); //add to the index
                internalFrame.add(new JInternalFrame("Picture" + i, true, true, true, true)); //add the internalFrame to JDesktopPane
                internalFrame.get(index.size() - 1).addInternalFrameListener(new internalFrameEvent()); //add the event to the internalFrame
                menuItemWindow = new JMenuItem("Picture" + i);
                
                menuItemWindow.setMnemonic(i);
                menuWindow.add(menuItemWindow);
                
                
                
                
                menuItemWindow.addActionListener(new ActionListener(){ //set the focus to certain internalFrame each time the user click on certain item
                    
                    public void actionPerformed(ActionEvent event){
                        int j = 0;
                         
                        JMenuItem menuItemTemp = (JMenuItem) event.getSource(); //get the object and identified it   
                        for (String name : index){ //return the index of the index ArrayList if match with that item
                            if (name.equals(menuItemTemp.getText()))
                                break;    
                            j++;
                        }
                        
                        try{                           
                            internalFrame.get(j).toFront();//set internal Frame to the front and focus base on user selection
                            internalFrame.get(j).show();
                            internalFrame.get(j).setSelected(true);                          
                        }catch(Exception e){
                           e.printStackTrace();
                        }        
                        
                    }
                    
                });//end menuItemWindow actionListener()
                
                
                
                internalFrame.get(index.size() - 1).setSize(dim); //set internalFrame size
                internalPanel internalPanel = new internalPanel(); //create new InternalFrame object              
                internalFrame.get(index.size() - 1).add(internalPanel,BorderLayout.CENTER);               
                desktopPane.add(internalFrame.get(index.size() - 1)); //add internalFrame to jDesktopPane
                internalFrame.get(index.size() - 1).setVisible(true); //set visibility
                
            }
            
        
        });
        
        
        menuItemExit.addActionListener(new ActionListener(){ //exit the program when user click JMenu Exit
            public void actionPerformed(ActionEvent event){
                System.exit(0);  //exit the programe
            }
        });
   
    }//end constructor;
    
    
    class internalFrameEvent extends InternalFrameAdapter{ // add event to internalFrame, so it can remove or add jMenu each time user select it
       @Override
       public void internalFrameClosing(InternalFrameEvent event) {
           int j = 0;
           for (String name : index){ //get the title of the current focus internalFrame
               if (name.equals(event.getInternalFrame().getTitle()))             
                   break;
               j++;
           }          
           index.remove(j); //remove the internalFrame and JMenu if user click the internalFrame's exit buton
           internalFrame.remove(j);
           menuWindow.remove(j);          
       }      
    }//end internalFrame event 
    
}

class internalPanel extends JPanel{
    
    private final JLabel lblRed, lblGreen, lblBlue;
    private final JTextField txtRed, txtGreen, txtBlue;
    private final JSlider sliderRed, sliderGreen, sliderBlue;
    private final JComboBox cmbShape;
    private final  JCheckBox chkFilled;
    private final String[] cmbItem = {"Line", "Oval", "Rectangle", "Rounded Rectangle"};
    private final GridLayout gridlayout;
    private final JPanel panelSouth, panelNorth;
    private Color color;
    private int red, green, blue;
    private String shape = "Line";
    private int x1 = 0, y1 = 0, x2 = 0, y2 = 0, xo, yo;
    private ArrayList<A6Shapes> myGraphics;
    private boolean filled;
    
    public internalPanel(){
        
        setLayout(new BorderLayout());
        sliderRed = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0); //create all the components
        sliderGreen = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0); 
        sliderBlue = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
        lblRed = new JLabel("Red"); //create jlabels
        lblGreen = new JLabel("Green");
        lblBlue = new JLabel("Blue");
        txtRed = new JTextField("0"); //create textFields
        txtGreen = new JTextField("0");
        txtBlue = new JTextField("0");
        chkFilled = new JCheckBox("Filled");
        cmbShape = new JComboBox(cmbItem);
        myGraphics = new ArrayList<A6Shapes>();
        
        
        panelSouth = new JPanel();
        gridlayout = new GridLayout(3, 3);
        panelSouth.setLayout(gridlayout);
        panelSouth.add(lblRed); //add basic components to the panel
        panelSouth.add(sliderRed);
        panelSouth.add(txtRed);
        panelSouth.add(lblGreen);
        panelSouth.add(sliderGreen);
        panelSouth.add(txtGreen);
        panelSouth.add(lblBlue);
        panelSouth.add(sliderBlue);
        panelSouth.add(txtBlue);
        
        panelNorth = new JPanel();
        panelNorth.add(cmbShape);
        panelNorth.add(chkFilled);
        
        
        
        add(panelNorth, BorderLayout.NORTH); //add panels the the super
        add(panelSouth, BorderLayout.SOUTH); 
               
        txtRed.addActionListener(new textEvent()); // add all the event handling to the components
        txtGreen.addActionListener(new textEvent());
        txtBlue.addActionListener(new textEvent());
        sliderRed.addChangeListener(new changeEvent());
        sliderGreen.addChangeListener(new changeEvent());
        sliderBlue.addChangeListener(new changeEvent());
        
        cmbShape.addItemListener(new ItemListener(){ //add comboBox ItemListener to keep track of the select shape from user
            public void itemStateChanged(ItemEvent event){
                shape = cmbShape.getSelectedItem().toString();
            }
        });
        
        chkFilled.addItemListener(new ItemListener(){ //add checkBox ItemListener if user check to fill or not
             public void itemStateChanged(ItemEvent event){
                 if (chkFilled.isSelected() == true)//if it is selected
                     filled = true; //set true
                 else
                     filled = false;  //set false               
                 myGraphics.get(myGraphics.size() - 1).setFilled(filled); //change the filled of the arraylist
                 myGraphics.get(myGraphics.size() - 1).setColor(color = color(red, green, blue)); //change the color of the arrayList              
                repaint();
             }
        });
        
        
        addMouseListener(new mouseEvent()); //add mouseListener to the panel to have it interact with the mouse and draw the shapes
        addMouseMotionListener(new mouseMotion());
    
    }//end internalPanel constructor
    
    public void paintComponent(Graphics g){
       super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
         color = color(red, green, blue);
        
        for (A6Shapes graphics : myGraphics){ //draw all the old painted shapes, so we won't lose all of them when calling repaint
            g2d.setColor(graphics.getColor()); //set color for each individual shape we defined earlier
            switch (graphics.getShape()){
            case "Line":  //draw Line                              
                g2d.drawLine(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2());
                break;
            case "Oval":  //draw Oval  
                if (graphics.getFilled()) //if it is filled, when draw fill
                    g2d.fillOval(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2()); 
                g2d.drawOval(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2());
                break;
            
            case "Rectangle"://draw Rectangle               
                if (graphics.getFilled())//if it is filled, when draw fill
                    g2d.fillRect(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2());                
                g2d.drawRect(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2());
                break;               
            default:  //draw Round Rectangle    
               if (graphics.getFilled())//if it is filled, when draw fill
                    g2d.fillRoundRect(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2(), 20, 20); 
              g2d.drawRoundRect(graphics.getX1(), graphics.getY1(), graphics.getX2(), graphics.getY2(), 20, 20); 
            } 
        }
        
        g2d.setColor(color);
        switch (shape){ //draw shapes base on user selection           
            case "Line":  //draw line                              
                g2d.drawLine(x1, y1, x2,  y2 );  
                break;
            case "Oval": //draw Oval
                if (filled)
                    g2d.fillOval(x1, y1, x2 - x1,  y2 - y1); 
                g2d.drawOval(x1, y1, x2 - x1,  y2 - y1);
                break;    
            case "Rectangle": //draw Rectangle
                if (filled)
                    g2d.fillRect(x1, y1, x2 - x1,  y2 - y1);
                g2d.drawRect(x1, y1, x2 - x1,  y2 - y1);
                
                break;               
            default:      //draw Round rectangle
                if (filled)
                    g2d.fillRoundRect(x1, y1, x2 - x1,  y2 - y1, 20, 20);                 
                g2d.drawRoundRect(x1, y1, x2 - x1,  y2 - y1, 20, 20);                
        }      
    }//end paint components 
    
    private Color color(int red, int green, int blue){ //set and return color
        return (new Color(red, green, blue));
    }
   
    
    class textEvent implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int txt = 1; //keep track which textField user input wrong value
            JTextField txtField = (JTextField) event.getSource();
            try{                          
                if (txtField.equals(txtRed)){
                        red = Integer.parseInt(txtField.getText());
                    if (red > 255 || red < 0) //make sure user input value between 0 - 255
                        throw new IllegalArgumentException("value must be between 0 - 255");  //call exception if out of range
                        sliderRed.setValue(red); //set slidervalue if value is ok
                }else if(txtField.equals(txtGreen)){
                    txt = 2;
                     green = Integer.parseInt(txtField.getText());
                    if (green > 255 || green < 0) //make sure user input value between 0 - 255
                        throw new IllegalArgumentException("value must be between 0 - 255");  //call exception if out of range
                    sliderGreen.setValue(green); //set slidervalue if value is ok
                }else{
                    txt = 3;
                     blue = Integer.parseInt(txtField.getText());
                    if (blue > 255 || blue < 0) //make sure user input value between 0 - 255
                        throw new IllegalArgumentException("value must be between 0 - 255");  //call exception if out of range
                    sliderBlue.setValue(blue); //set slidervalue if value is ok
                }
                repaint();
            }catch (NumberFormatException exception){//call exception
                
                JOptionPane.showMessageDialog(null, "Please enter number only", "Message", JOptionPane.INFORMATION_MESSAGE);
                resetColor(txt); //set value to 0 if users input wrong value
            }catch (IllegalArgumentException exception){ //call exception
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Message", JOptionPane.INFORMATION_MESSAGE);
                resetColor(txt); //set value to 0 if users input wrong value
            }
            
            
        }
        private void resetColor(int txt){ //if the user input inappropriate value, set value back to 0
            switch (txt){
                    case 1: txtRed.setText("0"); red = 0;break; // set textField, and color to 0 when users input wrong value
                    case 2: txtGreen.setText("0"); green = 0; break;
                    default: txtBlue.setText("0"); blue = 0;
                }
                
                sliderRed.setValue(red); //set the Jsliders value to 0
                sliderGreen.setValue(green);
                sliderBlue.setValue(blue);
        }
    }//end textEvent()
    
    //add JSlider event handler
    class changeEvent implements ChangeListener{
        public void stateChanged(ChangeEvent event){
            JSlider slider = (JSlider) event.getSource();
            if (slider.equals(sliderRed)){
               txtRed.setText(String.valueOf(slider.getValue())); //set the JSlider value to txtField
               red = slider.getValue(); //set the color
              
            }else if (slider.equals(sliderGreen)){
               txtGreen.setText(String.valueOf(slider.getValue()));//set the JSlider value to txtField
               green = slider.getValue(); //set the color
              
            }else{
               txtBlue.setText(String.valueOf(slider.getValue()));//set the JSlider value to txtField
               blue = slider.getValue(); //set the color
              
            } 
            if (myGraphics.size() > 0)
                myGraphics.get(myGraphics.size() - 1).setColor(color = color(red, green, blue));
            repaint();
        }
    }//end changeEvent()
    
     private class mouseEvent extends MouseAdapter{
        // add mouse pressed event
        public void mousePressed(MouseEvent event){ 
           x1 = event.getX();
           y1 = event.getY();
           xo = x1; //keep the old x1, y1
           yo = y1;
           
        }
        // add the mouse release event
        public void mouseReleased(MouseEvent event){ 
            x2 = event.getX();
            y2 = event.getY();
            x1 = xo; //set the old x1 ,and y1
            y1 = yo;
            setCoordinates(x1, y1, x2, y2);
            
            
            if (!shape.endsWith("Line")){ //make sure if is not "line"
                x2 = x2 - x1; 
                y2 = y2 - y1;              
            }
           
             //add the old shape to the arrayList for repaint 
            myGraphics.add(new A6Shapes(shape, x1, y1, x2, y2, color, filled));      
        }
    }
    
    // add mouse motion listener
    private class mouseMotion extends MouseMotionAdapter{ 
        public void mouseDragged(MouseEvent event){
            x2 = event.getX(); //get the x2 and y2 
            y2 = event.getY();
            x1 = xo; //set back the old x1, and y1 position
            y1 = yo;
            setCoordinates(x1, y1, x2, y2);           
            repaint(); //call repaint
        }
    }
    
    private void setCoordinates(int x1, int y1, int x2, int y2){ //set the directions
        int x = 0, y = 0, s = 0;     
        if (!shape.equals("Line")){ //if it is not line shape
            if ((x1 <= x2 ) && (y1 >= y2)){ //swap  y1  and y2 if they are in first quadrant to make it draw backward               
                   y = y1; 
                   y1 = y2;
                   y2 = y;
                
                if (shape.equals("Square")){
                    s = ((x2 - x1) + (y2 - y1)) / 2;
                    x2 = s;
                    y2 = s;
                }
            }else if ((x1 >= x2) && (y1 >= y2)){ //swap  both x and y if they are in second quadrant to make it draw backward
                x = x1; //swap the x and y 
                y = y1;
                x1 = x2;
                y1 = y2;
                x2 = x;
                y2 = y;
               
            }else if ((x1 >= x2) && (y1 <= y2)){ ////swap  x1  with x2 if they are in third quadrant to make it draw backward
                x = x1; //swap the x
                x1 = x2;
                x2 = x;  
            }           
            this.x1 = x1; //set x and y coordinate to the global variables
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            
   
        }
    }
    
}