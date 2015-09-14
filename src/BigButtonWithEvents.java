
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BigButtonWithEvents implements Runnable, ActionListener, WindowFocusListener {
	private static JFrame frame;

	public static void main(String[] arg) {
		frame = new JFrame();
		BigButtonWithEvents app = new BigButtonWithEvents();
		Thread t = new Thread(app);
		t.start();
	}

	@Override
	public void run() {
		Container pane = frame.getContentPane();
		JButton button = new JButton("Push Me!");
		button.setPreferredSize(new Dimension(400, 40));
		
		pane.add(button);
		frame.addWindowFocusListener(this);
		button.addActionListener(this);
		// get screen dimensions and set frame to the middle of the screen.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 3 - frame.getSize().width / 3, dim.height / 3 - frame.getSize().height / 3);
		// frame stuff
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "I've been pushed!");
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		frame.setTitle("Idle...");
		// System.out.println("NOT Focused!" + frame.getTitle());
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		frame.setTitle("Receiving Keyboard Input");
		// System.out.println("Focused!" + frame.getTitle());
	}

}
