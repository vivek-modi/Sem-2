package Recursion.Q4;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

class MyFrameRecursionQ4 extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("  Recurstion   Application  ");
	private JLabel l1 = new JLabel("             List");
	private JTextField t1 = new JTextField("0", 15);
	private JLabel l2 = new JLabel(" Enter Target");
	private JTextField t4 = new JTextField("0", 15);
	private JButton b1 = new JButton("  searchTarget");
	private JTextField t2 = new JTextField("0", 15);
	private JButton b2 = new JButton("allOdd");
	private JTextField t3 = new JTextField("0", 15);
	private JPanel p1 = new JPanel();

	ArrayList<Integer> arr = new ArrayList();

	public static boolean searchTarget(ArrayList list, int tar) { // to be completed
		if (list.size() == 0)
			return false;
		else {
			int first = (Integer) list.get(0);
			list.remove(0);
			if (first != tar) {
				return searchTarget(list, tar);
			} else {
				return true;
			}
		}
	}

	public static boolean allOdd(ArrayList list) { // to be completed
		boolean res = true;

		if (list.size() == 0)
			return false;
		else {
			int first = (Integer) list.get(0);
			list.remove(0);
			if (first % 2 == 1)
				return allOdd(list);
			else
				return false;

		}
	}

	public MyFrameRecursionQ4(String s) {
		super(s);
		Collections.addAll(arr, 5, 3, 5, 3, 7, 9, 5, 1, 8);
		java.awt.Container content = getContentPane();
		displayList();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(4, 2));
		l0.setFont(f);
		l1.setFont(f);
		l2.setFont(f);
		content.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t4);
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

			int t = Integer.parseInt(t4.getText());
			boolean v1 = this.searchTarget(new ArrayList(arr), t);
			t2.setText("" + v1);
		}

		if (target == b2) {

			boolean v1 = this.allOdd(new ArrayList(arr));
			t3.setText("" + v1);
		}
	}
}
