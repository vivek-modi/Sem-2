package Thread.Thread_Karls;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.text.DefaultCaret;

class anObject implements Runnable {
	private boolean suspendFlag = false;
	private boolean exit = false;
	private int value;
	private String threadName;
	private int counter = 1;
	JProgressBar pbar = new JProgressBar();
	JTextArea output = new JTextArea();

	public anObject(String t, int v, JProgressBar pb, JTextArea op) {
		threadName = t;
		value = v;
		pbar = pb;
		output = op;
	}

	public void run() {
		counter = 1;
		while (pbar.getValue() < 100 && !exit) {
			pbar.setValue((int) (counter * 100 / value));
			counter++;
			// System.out.println("Thread No: "+threadName+"\tPrecent:
			// "+(int)(counter*100/value));
			output.append(
					"Thread No: " + threadName + "\t\tPrecent Completed: " + (int) (counter * 100 / value) + "%\n");
			try {
				Thread.sleep((int) (Math.random() * 1000));
				// Thread.sleep(1000);
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		// System.out.println("Thread No: "+threadName+"\tFinished");
		output.append("Thread No: " + threadName + "\t\tFinished\n");

	}

	public void myStop() {
		// System.out.println("Thread No: "+threadName+"\tSTOPPED\n");
		output.append("Thread No: " + threadName + "\t\tSTOPPED\n");
		exit = true;
	}

	public void mySuspend() {
		// System.out.println("Thread No: "+threadName+"\tSUSPENDED");
		output.append("Thread No: " + threadName + "\t\tSUSPENDED\n");
		suspendFlag = true;
	}

	public synchronized void myResume() {
		// System.out.println("Thread No: "+threadName+"\tRESUMED\n");
		output.append("Thread No: " + threadName + "\t\tRESUMED\n");
		suspendFlag = false;
		notify();
	}
}

class PBFrame extends JFrame implements ActionListener, WindowListener {
	Random r = new Random();

	private JLabel l1 = new JLabel("Thread 1:");
	private JTextField tf1 = new JTextField("" + (r.nextInt(99) + 1));
	private JProgressBar pb1 = new JProgressBar(0, 100);
	private JButton t1_pause = new JButton("Pasue");
	private JButton t1_resume = new JButton("Resume");
	private JButton t1_stop = new JButton("Stop");

	private JLabel l2 = new JLabel("Thread 2:");
	private JTextField tf2 = new JTextField("" + (r.nextInt(99) + 1));
	private JProgressBar pb2 = new JProgressBar(0, 100);
	private JButton t2_pause = new JButton("Pause");
	private JButton t2_resume = new JButton("Resume");
	private JButton t2_stop = new JButton("Stop");

	private JLabel l3 = new JLabel("Thread 3:");
	private JTextField tf3 = new JTextField("" + (r.nextInt(99) + 1));
	private JProgressBar pb3 = new JProgressBar(0, 100);
	private JButton t3_pause = new JButton("Pasue");
	private JButton t3_resume = new JButton("Resume");
	private JButton t3_stop = new JButton("Stop");

	private JButton start_ALL = new JButton("Start All");
	private JButton pause_ALL = new JButton("Pause All");
	private JButton resume_ALL = new JButton("Resume All");
	private JButton stop_ALL = new JButton("Stop All");
	private JButton close = new JButton("Quit");

	private JTextArea outputArea = new JTextArea(10, 45);
	private JScrollPane scrollPane;

	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();

	anObject obj1;
	anObject obj2;
	anObject obj3;

	public PBFrame(String s) {
		super(s);
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		setFormatCompoments();

		p1.setLayout(new GridLayout(3, 5));
		p1.add(l1);
		p1.add(tf1);
		p1.add(t1_pause);
		p1.add(t1_resume);
		p1.add(t1_stop);
		p1.add(l2);
		p1.add(tf2);
		p1.add(t2_pause);
		p1.add(t2_resume);
		p1.add(t2_stop);
		p1.add(l3);
		p1.add(tf3);
		p1.add(t3_pause);
		p1.add(t3_resume);
		p1.add(t3_stop);

		pb1.setForeground(Color.RED);
		pb2.setForeground(Color.BLACK);
		pb3.setForeground(Color.BLUE);

		p2.setLayout(new GridLayout(1, 5));
		p2.add(start_ALL);
		p2.add(pause_ALL);
		p2.add(resume_ALL);
		p2.add(stop_ALL);
		p2.add(close);
		start_ALL.addActionListener(this);
		pause_ALL.addActionListener(this);
		resume_ALL.addActionListener(this);
		stop_ALL.addActionListener(this);
		close.addActionListener(this);

		t1_pause.addActionListener(this);
		t1_resume.addActionListener(this);
		t1_stop.addActionListener(this);
		t2_pause.addActionListener(this);
		t2_resume.addActionListener(this);
		t2_stop.addActionListener(this);
		t3_pause.addActionListener(this);
		t3_resume.addActionListener(this);
		t3_stop.addActionListener(this);

		p3.setLayout(new GridLayout(1, 3));
		p3.add(pb1);
		p3.add(pb2);
		p3.add(pb3);

		outputArea.setEditable(false);
		outputArea.setLineWrap(true);
		outputArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(outputArea);
		DefaultCaret caret = (DefaultCaret) outputArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		p4.setLayout(new FlowLayout());
		p4.add(scrollPane);

		content.add(p1);
		content.add(p3);
		content.add(p4);
		content.add(p2);
		setSize(550, 450);
		// setResizable(false);
		setVisible(true);
	}

	public void setFormatCompoments() {
		/**
		 * Set up the fonts to be used in the GUI and apply them to the components
		 */
		Font f = new Font("Comic Sans MS", Font.BOLD, 14);
		Font f1 = new Font("Comic Sans MS", Font.PLAIN, 14);

		outputArea.setFont(f1);

		l1.setOpaque(true);
		l1.setBackground(Color.red);
		l1.setForeground(Color.white);
		l2.setOpaque(true);
		l2.setBackground(Color.black);
		l2.setForeground(Color.white);
		l3.setOpaque(true);
		l3.setBackground(Color.blue);
		l3.setForeground(Color.white);

		l1.setFont(f);
		tf1.setFont(f);
		l2.setFont(f);
		tf2.setFont(f);
		l3.setFont(f);
		tf3.setFont(f);

		start_ALL.setFont(f1);
		pause_ALL.setFont(f1);
		resume_ALL.setFont(f1);
		stop_ALL.setFont(f1);
		close.setFont(f1);
		t1_pause.setFont(f1);
		t1_resume.setFont(f1);
		t1_stop.setFont(f1);
		t2_pause.setFont(f1);
		t2_resume.setFont(f1);
		t2_stop.setFont(f1);
		t3_pause.setFont(f1);
		t3_resume.setFont(f1);
		t3_stop.setFont(f1);
		pb1.setStringPainted(true);
		pb2.setStringPainted(true);
		pb3.setStringPainted(true);
	}

	public void ResetProgressBars() {
		pb1.setValue(0);
		pb1.repaint();
		pb2.setValue(0);
		pb2.repaint();
		pb3.setValue(0);
		pb3.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		/* Get the selected values fromt he comboboxed and store them in v1 and v2 */
		Random r = new Random();
		int rand = r.nextInt(100 - 1) + 1;

		Object target = e.getSource();
		if (target == start_ALL) {
			ResetProgressBars();
			outputArea.setText("");
			outputArea.append("Thread 1: " + tf1.getText() + "\tThread 2: " + tf2.getText() + "\tThread 3: "
					+ tf3.getText() + "\n");
			obj1 = new anObject("1", Integer.parseInt(tf1.getText()), pb1, outputArea);
			obj2 = new anObject("2", Integer.parseInt(tf2.getText()), pb2, outputArea);
			obj3 = new anObject("3", Integer.parseInt(tf3.getText()), pb3, outputArea);

			Thread t1 = new Thread(obj1);
			Thread t2 = new Thread(obj2);
			Thread t3 = new Thread(obj3);
			t1.start();
			t2.start();
			t3.start();
		}
		if (target == close) {
			System.exit(0);
		}
		if (target == resume_ALL) {
			obj1.myResume();
			obj2.myResume();
			obj3.myResume();
		}
		if (target == pause_ALL) {
			obj1.mySuspend();
			obj2.mySuspend();
			obj3.mySuspend();
		}
		if (target == stop_ALL) {
			obj1.myStop();
			obj2.myStop();
			obj3.myStop();
		}
		if (target == t1_pause)
			obj1.mySuspend();
		if (target == t1_resume)
			obj1.myResume();
		if (target == t1_stop)
			obj1.myStop();
		if (target == t2_pause)
			obj2.mySuspend();
		if (target == t2_resume)
			obj2.myResume();
		if (target == t2_stop)
			obj2.myStop();
		if (target == t3_pause)
			obj3.mySuspend();
		if (target == t3_resume)
			obj3.myResume();
		if (target == t3_stop)
			obj3.myStop();
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

public class GUI_MultiProgressBar {
	public static void main(String[] args) {
		PBFrame f = new PBFrame("Software Design 4.2 - Threads Example");
	}
}