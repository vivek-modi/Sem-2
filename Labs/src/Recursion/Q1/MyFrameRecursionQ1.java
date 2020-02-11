package Recursion.Q1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

class MyFrameRecursionQ1 extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("  Recurstion   Application  ");
	private JLabel l1 = new JLabel("             List");
	private JTextField t1 = new JTextField("0", 15);
	private JButton b1 = new JButton("Sum");
	private JTextField t2 = new JTextField("0", 15);
	private JButton b2 = new JButton("Odd");
	private JTextField t3 = new JTextField("0", 15);
	private JPanel p1 = new JPanel();

	ArrayList<Integer> arr = new ArrayList();

	public static int sum(ArrayList list) { // to be completed
		if (list.size() == 0)
			return 0;
		else {
			int first = (Integer) list.get(0);
			list.remove(0);
			return first + sum(list);
		}
	}

	public static int countOdd(ArrayList list) { // to be completed
		int res = 0;

		return res;
	}

	public MyFrameRecursionQ1(String s) {
		super(s);
		Collections.addAll(arr, 5, 3, 9, 3, 8, 7, 5, 1);
		java.awt.Container content = getContentPane();
		displayList();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(3, 2));
		l0.setFont(f);
		l1.setFont(f);
		content.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		p1.add(t2);
		p1.add(b2);
		p1.add(t3);
		content.add(p1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(390, 200);
		setVisible(true);
	}

	public void displayList() {
		String res = "[" + (Integer) arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			res += ", " + (Integer) arr.get(i);
		}
		t1.setText(res + "]");
	}

	public void actionPerformed(ActionEvent e) {

		Object target = e.getSource();
		if (target == b1) {
			int v1 = this.sum(new ArrayList(arr));
			t2.setText("" + v1);
		}

		if (target == b2) {
			int v1 = this.countOdd(new ArrayList(arr));
			t3.setText("" + v1);
		}
	}
}
