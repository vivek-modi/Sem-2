package Thread.Q10;

import java.awt.Graphics;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Producer extends Thread {
	private NumberStore store;
	private int number;

	public Producer(NumberStore ns, int n) {
		store = ns;
		number = n;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			store.put(i);
			// System.out.println("Producer #"+ this.number + " put: " + i);
			try {
				sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumer extends Thread {
	private NumberStore store;
	private int number;

	public Consumer(NumberStore ns, int n) {
		store = ns;
		number = n;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = store.get();
			System.out.println("Consumer #" + this.number + " got: " + value);
			try {
				sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
			}
		}
	}
}

//-----------------------------------------------------------------------------------

class NumberStore {
	private int contents = 0;
	private boolean available = false;

	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		notify();
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		contents = value;
		available = true;
		notify();
	}
}

//---------------------------------------------------------------------------------------
public class Sliced1 {
	public static void main(String[] args) {
		NumberStore ns = new NumberStore();
		Producer p = new Producer(ns, 1);
		Consumer c = new Consumer(ns, 1);
		p.start();
		c.start();
	}
}
