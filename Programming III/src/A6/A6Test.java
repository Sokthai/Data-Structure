package A6;
// Written by: SOKTHAI TANG
// Description: This programs will allow users to draw any the shapes they want
//              users have the ability to change color and fill
// Time Spent: About 5 hour

//            Revision History
// Date:            By:             Action:
// 12/16/2015       sokthai tang    created date
// ---------------------------------------------------

//package Assignment_VI;
import javax.swing.JFrame;
import java.awt.Dimension;

public class A6Test{
    public static void main(String[] args){
        A6 frame = new A6();
        Dimension dim = new Dimension(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(dim);
        
    }
}