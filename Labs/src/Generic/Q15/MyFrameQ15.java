package Generic.Q15;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.*;

class MyFrameQ15 extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("  HashMap  Application  ");
	private JLabel l1 = new JLabel("             List");
	private JTextField t1 = new JTextField("0", 55);
	private JButton b1 = new JButton("Add Element");
	private JTextField t2 = new JTextField("0", 15);
	private JTextField t3 = new JTextField("0", 15);
	private JButton b2 = new JButton(" Search City by Key");
	private JTextField t4 = new JTextField("2", 15);
	private JTextField t5 = new JTextField("", 15);
	private JButton b3 = new JButton("Change City Name:");
	private JTextField t6 = new JTextField("2", 15);
	private JTextField t7 = new JTextField("", 15);

	private JPanel p1 = new JPanel();

	private JPanel p2 = new JPanel();
	Map<Integer, String> list = new HashMap<Integer, String>();

	static String search(Map<Integer, String> map, Integer i) {
		return map.get(i);
	}

	static void changeCity(Map<Integer, String> map, Integer i, String city) {
		map.put(i, city);
	}

	static String print(Map<Integer, String> map) {
		StringBuffer res = new StringBuffer("{ ");

		Set<Entry<Integer, String>> keys = map.entrySet();
		Iterator i = keys.iterator();
		if (i.hasNext())
			res.append("" + i.next());
		while (i.hasNext()) {
			res.append("," + i.next());
		}
		res.append("}");
		return res.toString();
	}

	public MyFrameQ15(String s) {
		super(s);
		Container content = getContentPane();
		list.put(1, "Athlone");
		list.put(2, "Paris");
		list.put(3, "New York");
		list.put(4, "Milan");
		displayList(list);
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		Font f2 = new Font("TimesRoman", Font.BOLD, 14);
		p1.setLayout(new GridLayout(1, 1));

		p2.setLayout(new GridLayout(3, 3));

		l0.setFont(f);
		l1.setFont(f);
		content.add(l0);
		t1.setFont(f2);
		p1.add(t1);
		p2.add(b1);
		p2.add(t2);
		p2.add(t3);
		p2.add(b2);
		p2.add(t4);
		p2.add(t5);
		p2.add(b3);
		p2.add(t6);
		p2.add(t7);
		content.add(p1);
		content.add(p2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setSize(700, 200);
		setVisible(true);
	}

	public void displayList(Map<Integer, String> list) {

		t1.setText("List=" + print(list));
	}

	public void actionPerformed(ActionEvent e) {

		Object target = e.getSource();
		if (target == b1) {
			int v1 = Integer.parseInt(t2.getText());
			String v2 = t3.getText();
			list.put(v1, v2);
			displayList(list);

		}

		if (target == b2) { // search
			int key = Integer.parseInt(t4.getText());
			String res = search(list, key);
			t5.setText("" + res);
		}
		if (target == b3) { // modify city name
			int key = Integer.parseInt(t6.getText());
			String city = t7.getText();
			changeCity(list, key, city);
			displayList(list);
		}

	}
}
