
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BigButton implements Runnable, ActionListener {
	private static JFrame frame;

	public static void main(String[] arg) {
		frame = new JFrame();
		BigButton app = new BigButton();
		Thread t = new Thread(app);
		t.start();
	}

	@Override
	public void run() {
		Container pane = frame.getContentPane();
		JButton button = new JButton("Push Me!");
		pane.add(button);
		button.addActionListener(this);
		// get screen dimensions and set frame to the middle of the screen.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		// frame stuff 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "I've been pushed!");
	}

}
