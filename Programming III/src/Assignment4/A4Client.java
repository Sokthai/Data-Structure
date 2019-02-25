// File name: A4Client.java
// Written by: Sokthai Tang
// Description: This program will allow user to draw base on the shapes they want.
//              user can also change to difference color
// Time Spent: About 5 hour

//            Revision History
// Date:            By:             Action:
// 10/30/2015       sokthai tang    created date
// ---------------------------------------------------
package Assignment4;
import javax.swing.JFrame;
import java.awt.Dimension;
public class A4Client{
    public static void main(String[] args){
        
        Dimension d = new Dimension(500, 500); // create window dimension
        JFrame frame = new JFrame("Drawing");
        A4 A4 = new A4();
        frame.add(A4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(d);    
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}