package Thread_Karls;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class aObject implements Runnable {
	private boolean suspendFlag = false;
	private boolean exit = false;
	private int value;
	private String threadName;
	private int counter = 1;
	JProgressBar pbar = new JProgressBar();

	public aObject(String t, int v, JProgressBar pb) {
		threadName = t;
		value = v;
		pbar = pb;
	}

	public void run() {
		counter = 1;
		while (pbar.getValue() < 100 && !exit) {
			pbar.setValue((int) (counter * 100 / value));
			counter++;
			System.out.println("Thread No: " + threadName + "\tPrecent: " + (int) (counter * 100 / value));
			try {
				Thread.sleep((int) (Math.random() * 1000));
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		System.out.println("Thread No: " + threadName + "\tFinished");

	}

	public void myStop() {
		System.out.println("Thread No: " + threadName + "\tSTOPPED\n");
		exit = true;
	}

	public void mySuspend() {
		System.out.println("Thread No: " + threadName + "\tSUSPENDED");
		suspendFlag = true;
	}

	public synchronized void myResume() {
		System.out.println("Thread No: " + threadName + "\tRESUMED\n");
		suspendFlag = false;
		notify();
	}
}

class PBFrame1 extends JFrame implements ActionListener, WindowListener {
	Random r = new Random();
	private JLabel l1 = new JLabel("Thread:");
	private JTextField tf1 = new JTextField("" + (r.nextInt(99) + 1));
	private JProgressBar pb1 = new JProgressBar(0, 100);
	private JButton t1_start = new JButton("Start");
	private JButton t1_pause = new JButton("Pasue");
	private JButton t1_resume = new JButton("Resume");
	private JButton t1_stop = new JButton("Stop");
	private JButton close = new JButton("Quit");
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();

	aObject obj1;

	public PBFrame1(String s) {
		super(s);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		setFormatCompoments();

		p1.setLayout(new GridLayout(1, 2));
		p1.add(l1);
		p1.add(tf1);
		pb1.setForeground(Color.GRAY);

		t1_start.addActionListener(this);
		t1_pause.addActionListener(this);
		t1_resume.addActionListener(this);
		t1_stop.addActionListener(this);
		close.addActionListener(this);

		p2.setLayout(new GridLayout(1, 5));
		p2.add(t1_start);
		p2.add(t1_pause);
		p2.add(t1_resume);
		p2.add(t1_stop);
		p2.add(close);

		p3.setLayout(new GridLayout(3, 1));
		p3.add(p1);
		p3.add(p2);
		p3.add(pb1);

		content.add(p3);
		setSize(500, 150);
		setResizable(false);
		setVisible(true);
	}

	public void setFormatCompoments() {
		/**
		 * Set up the fonts to be used in the GUI and apply them to the components
		 */
		Font f = new Font("Comic Sans MS", Font.BOLD, 14);
		Font f1 = new Font("Comic Sans MS", Font.PLAIN, 14);
		// l1.setOpaque(true); l1.setBackground(Color.red);
		// l1.setForeground(Color.white);
		l1.setFont(f);
		tf1.setFont(f);
		t1_start.setFont(f1);
		close.setFont(f1);
		t1_pause.setFont(f1);
		t1_resume.setFont(f1);
		t1_stop.setFont(f1);
		pb1.setStringPainted(true);
	}

	public void ResetProgressBars() {
		pb1.setValue(0);
		pb1.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		/* Get the selected values fromt he comboboxed and store them in v1 and v2 */
		Random r = new Random();
		int rand = r.nextInt(100 - 1) + 1;

		Object target = e.getSource();
		if (target == t1_start) {
			ResetProgressBars();
			obj1 = new aObject("1", Integer.parseInt(tf1.getText()), pb1);
			Thread t1 = new Thread(obj1);

			t1.start();
		}
		if (target == close) {
			System.exit(0);
		}
		if (target == t1_pause)
			obj1.mySuspend();
		if (target == t1_resume)
			obj1.myResume();
		if (target == t1_stop)
			obj1.myStop();
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.exit(0);
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
}

public class GUI_ProgressBar1 {
	public static void main(String[] args) {
	 new PBFrame1("Software Design 4.2 - Thread Progress Bar Example");
	}
}