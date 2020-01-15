package Q6;

import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ClockThreadSkel6 implements ActionListener {
	JFrame jf = new JFrame();
	Display24 clockThread24 = null;
	JLabel time24 = new JLabel("                ");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton stop24 = new JButton("STOP24");
	JButton restart24 = new JButton("RESTART24");
	Container content;

	public ClockThreadSkel6() {
		jf.setSize(100, 150);
		content = jf.getContentPane();
		content.setLayout(new FlowLayout());
		p1.setLayout(new GridLayout(1, 1));
		p2.setLayout(new GridLayout(2, 1));
		stop24.addActionListener(this);
		restart24.addActionListener(this);
		p1.add(time24);
		time24.setBackground(Color.yellow);
		p2.add(stop24);
		stop24.setBackground(Color.yellow);
		p2.add(restart24);
		restart24.setBackground(Color.yellow);
		content.add(p1);
		content.add(p2);
		clockThread24 = new Display24(time24);
		clockThread24.start();
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource();
		if (target == stop24)
			clockThread24.suspend();
		if (target == restart24)
			clockThread24.resume();
	}

	public static void main(String[] args) {
		ClockThreadSkel6 ct = new ClockThreadSkel6();
	}
}

class Display24 extends Thread {

	private JLabel l24;

	public Display24(JLabel l1) {
		l24 = l1;
	}

	public void updatedisplay() {

		Date now = new Date();
		SimpleDateFormat dtf = new SimpleDateFormat("HH:mm:ss");
		l24.setText(dtf.format(now)); // 2016/11/16 12:08:43

	}

	public void run() {
		while (true) {

			updatedisplay();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
