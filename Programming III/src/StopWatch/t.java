package StopWatch;

import java.awt.Dimension;

import javax.swing.JFrame;

public class t {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Dimension dim = new Dimension(1000, 1200);
				JFrame frame = new JFrame("Alarm Clock");
				StopWatch clock = new StopWatch();
				frame.add(clock);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(dim);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
	}

}
