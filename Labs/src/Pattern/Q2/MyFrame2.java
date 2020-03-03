package Pattern.Q2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame2 extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("Counter  Application  ");
	private JLabel l1 = new JLabel("Count ");
	private JTextField t2 = new JTextField(" ", 8);
	private JLabel l2 = new JLabel("Max ");
	private JTextField t1 = new JTextField(" ", 8);
	private JButton b1 = new JButton("Add");
	private JButton b2 = new JButton("Cancel");
	private JLabel l3 = new JLabel("Message ");
	private JTextField t3 = new JTextField("0", 8);
	private boolean res = true;

	private JPanel p1 = new JPanel();

	public MyFrame2(String s) {
		super(s);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(4, 2));
		l0.setFont(f);
		content.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(b1);
		p1.add(b2);
		p1.add(l3);
		p1.add(t3);

		content.add(p1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		Outing o = new Outing();
		refresh(o);
		setSize(210, 230);
		setVisible(true);
	}

	public void refresh(Outing o) {
		t1.setText("" + o.readCount());
		t2.setText("" + o.readMax());
		if (res == false)
			t3.setText("Error");
		else
			t3.setText("");
	}

	public void actionPerformed(ActionEvent e) {

		Object target = e.getSource();
		if (target == b1) {
			Outing o = Outing.getInstance();
			res = o.add();
			refresh(o);
		}
		if (target == b2) {
			Outing o = Outing.getInstance();
			res = o.cancel();
			refresh(o);
		}

	}

}