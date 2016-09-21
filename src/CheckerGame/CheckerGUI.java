package CheckerGame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class CheckerGUI {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Checkers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckerPanel panel = new CheckerPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		frame.setJMenuBar(panel.topMenu);
		frame.pack();
		frame.setVisible(true);
		
	}
}
