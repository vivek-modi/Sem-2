package Thread.Q8;

import java.awt.Graphics;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Join2 {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				System.out.println("EnterValue:");
				try {
					System.in.read();
				} catch (Exception ex) {
				}
				System.out.println("Thread Finished.");
			}
		};
		System.out.println("Starting Thread");
		t.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println("No Join");
		System.out.println("Main Finished.");
	}
}
