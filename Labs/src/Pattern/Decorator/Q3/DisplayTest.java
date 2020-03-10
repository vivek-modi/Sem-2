package Pattern.Decorator.Q3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DisplayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Display d = new LowerLine(new Display("Ahlone"));

		int choice = 1;

		while (choice != 3) {
			System.out.println();
			System.out.println("1.Display Name");
			System.out.println("2.Update Name");
			System.out.println("3.Exit");

			System.out.print("Please enter a value-->");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println();
				d.print();
			} else if (choice == 2) {
				System.out.print("Enter new Name:");
				String name = sc.next();
				d.update(name);
			}
		}
	}

}
