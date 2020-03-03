package Pattern.Q3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame1 extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("  Welcome Page  ");
	private JButton b1 = new JButton("Open");
	private JButton b2 = new JButton("Exit");
	private JPanel p1 = new JPanel();
	
	public MyFrame1(String s) {
		super(s);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(1, 2));
		l0.setFont(f);
		b1.setFont(f);
		b2.setFont(f);
		content.add(l0);
		p1.add(b1);
		p1.add(b2);
		content.add(p1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(210, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		Object target = e.getSource();
		if (target == b1) {
			MyFrame2 f =  MyFrame2.getInstance();
			f.setVisible(true);
		}

		if (target == b2) {
			System.exit(0);
		}
	}
}
