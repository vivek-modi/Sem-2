package DataStructure.Q1;


import java.awt.Graphics;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class SearchTest {

	public static boolean search(int[] list, int target) {

		for (int i : list) {
			if (i == target)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] list = { 4, 1, 3, 8, 5, 2, 11, 21, 6 };
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Target: ");
		int target = sc.nextInt();

		boolean res = search(list, target);
		System.out.println("Target Found: " + res);
	}
}
