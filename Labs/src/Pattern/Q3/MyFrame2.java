package Pattern.Q3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame2 extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("  Increment  Application  ");
	private JLabel l1 = new JLabel("Value1 ");
	private JTextField t1 = new JTextField("0", 8);
	private JButton b1 = new JButton("Incr");
	private JButton b2 = new JButton("Decr");
	private JButton b3 = new JButton("Close");
	private JPanel p1 = new JPanel();
	private static MyFrame2 INSTANCE;

	public MyFrame2() {
		super("Stepper");
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(2, 2));
		l0.setFont(f);
		l1.setFont(f);
		content.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		p1.add(b2);
		content.add(p1);
		content.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setSize(210, 200);
	}

	public static MyFrame2 getInstance() {
		return (INSTANCE == null) ? INSTANCE = new MyFrame2() : INSTANCE;
	}

	public void actionPerformed(ActionEvent e) {

		Object target = e.getSource();
		if (target == b1) {
			int v1 = Integer.parseInt(t1.getText());
			v1++;
			t1.setText("" + v1);
		}

		if (target == b2) {
			int v1 = Integer.parseInt(t1.getText());
			v1--;
			t1.setText("" + v1);
		}

		if (target == b3) {
			this.setVisible(false);
		}

	}
}
