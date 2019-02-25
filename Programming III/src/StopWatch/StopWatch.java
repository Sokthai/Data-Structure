package StopWatch;
import javax.swing.JApplet;
import java.applet.Applet;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.AudioClip;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class StopWatch extends JApplet {
    Dimension  dim =  new Dimension(500,400);
    private Double dia, xo, yo, theta;
    private Double r, x1, y1, x2, y2;
    private JPanel panel;
    private JRadioButton bell, alarm, dog;
    private ButtonGroup buttonGroup;
    private Icon bellIcon, alarmIcon, dogIcon;
    private Timer timer;
    int k, angle = -15, minutes = 0;
    private boolean run = false;
    private AudioClip[] sound;
    
    private Thread runner;
   
    private boolean start = false;
    private Graphics ga;
    
    
    
    public void init(){
        setSize(dim);
        panel = new JPanel();
        //panel.setLayout(new GridLayout(1, 3));
        buttonGroup = new ButtonGroup();
        
        sound = new AudioClip[3];
        System.out.println(getClass().getResource("bell.au"));
        sound[0] = getAudioClip(getClass().getResource("bell.au"));
        sound[1] = getAudioClip(getClass().getResource("alarm.au"));
        sound[2] = getAudioClip(getClass().getResource("dog.au"));
        
        bellIcon = new ImageIcon(getClass().getResource("bell.png"));
        alarmIcon = new ImageIcon(getClass().getResource("alarm.png"));
        dogIcon = new ImageIcon(getClass().getResource("dog.png"));
        
        bell = new JRadioButton("Bell", true);
        alarm = new JRadioButton("Alarm", false);
        dog = new JRadioButton("Dog", false);
        
        bell.addItemListener(new radioEvent(0));
        alarm.addItemListener(new radioEvent(1));
        dog.addItemListener(new radioEvent(2));
        
        
        
        
        panel.add(bell, BorderLayout.EAST);
        
        panel.add(alarm, BorderLayout.CENTER);
        panel.add(dog, BorderLayout.EAST);
        //panel.setBackground(Color.red);
        
        add(panel, BorderLayout.SOUTH);
        
        
        buttonGroup.add(bell);
        buttonGroup.add(alarm);
        buttonGroup.add(dog);
        
       
        
        xo = new Double(getWidth() * 0.2);
        yo = new Double(getHeight() * 0.1);
        r = new Double((getWidth() * 0.3));
        
        timer = new Timer(1000, new ActionListener(){
            
            public void actionPerformed(ActionEvent event){              
                theta = 6 * ( Math.PI / 180);                
                theta *= angle;              
                
                x2 = r * Math.cos(theta) + x1;
                y2 = r * Math.sin(theta) + y1;
                
             
                showStatus("Time left: " + String.valueOf(minutes));
                if ((minutes == 0 ) || (minutes == 60)) {                                                     
                    sound[k].play();
                    stop();                    
                }
                angle--;
                minutes--;
                
                repaint();

            }                       
        });
        
        x1 = xo + r;
        y1 = yo + r;
        x2 = x1;
        y2 = y1 - r ;
        
        addMouseListener(new mouseAdapter());
        addMouseMotionListener(new mouseMotion());
       // runner = new Thread(this);
        
//       super.paint(ga);
//       ga.drawLine(10, 10, 100, 100);
       
    }
    
    
    
  
    
    public void start(){
          //timer.start();
  
          showStatus("Alarm started");
          
          
    }
    
    public void stop(){
       
        timer.stop();
        showStatus("Alarm Stopped");    
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.drawOval(xo.intValue(), yo.intValue(), r.intValue() * 2, r.intValue() * 2);
        g.drawString("0", x1.intValue() - 5, y1.intValue() - r.intValue() + 15);
        g.drawString("15", x1.intValue() + r.intValue() - 20, y1.intValue()+5);
        g.drawString("30", x1.intValue() - 5, y1.intValue() + r.intValue() - 5);
        g.drawString("45", x1.intValue() - r.intValue() + 5, y1.intValue()+5);
        
        g.drawLine(x1.intValue(), y1.intValue(), x2.intValue(), y2.intValue());
        
//        g.drawImage(getImage(getClass().getResource("bell.png")), 182, 365, this);
//        g.drawImage(getImage(getClass().getResource("alarm.png")), 275, 365, this);
//        g.drawImage(getImage(getClass().getResource("dog.png")), 370, 365, this);
    }
    
    public void destroy(){
        
    }
    
    public class radioEvent implements ItemListener{
        private int l;
        public radioEvent(int j){
            l = j;
        }
        public void itemStateChanged(ItemEvent event){
            k = l;
        }
    }
    
    
    private class mouseAdapter extends MouseAdapter{
        // add the mouse release event
        public void mouseReleased(MouseEvent event){ 
          double round; 
                 
           theta = Math.atan((event.getY() - y1)/(event.getX() - x1));
           round = Math.round((theta * (180 / Math.PI)) / 6);   
           
           theta = (round * 6) * (Math.PI / 180);
           angle = (int)(round);
            if(event.getX() < x1) {
                theta = Math.PI + theta;
                angle += 30;
            } 
            
            minutes = angle + 14;
            angle--;
           x2 = r * Math.cos(theta) + x1;
           y2 = r * Math.sin(theta) + y1;
          showStatus("Time left: " + String.valueOf(minutes + 1));    
          start = true;
          System.out.println(start);
           repaint();
           
          
           timer.start();
        }
    }
    
    // add mouse motion listener
    private class mouseMotion extends MouseMotionAdapter{ 
        public void mouseDragged(MouseEvent event){
          
         double round; 
                 
           theta = Math.atan((event.getY() - y1)/(event.getX() - x1));
           round = Math.round((theta * (180 / Math.PI)) / 6);   
           
           theta = (round * 6) * (Math.PI / 180);
           angle = (int)(round);
            if(event.getX() < x1) {
                theta = Math.PI + theta;
                angle += 30;
            } 
            
            minutes = angle + 14;
            angle--;
           x2 = r * Math.cos(theta) + x1;
           y2 = r * Math.sin(theta) + y1;
          showStatus("Time left: " + String.valueOf(minutes + 1));
          
           repaint();
           
        }
    
    }
    
    
    
    
}
        