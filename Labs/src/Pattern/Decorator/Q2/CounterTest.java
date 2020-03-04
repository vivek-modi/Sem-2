package Pattern.Decorator.Q2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CounterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Counter m = new Counter();

		Counter c = new HighWarning(new LowWarning(new Counter()));

		int choice = 1;

		while (choice != 5) {
			System.out.println();
			System.out.println("1.Increment");
			System.out.println("2.Decrement");
			System.out.println("3.Read Value");
			System.out.println("4.Exit");

			System.out.print("Please enter a value-->");
			choice = sc.nextInt();
			if (choice == 1) {
				c.increment();
				System.out.println("\n Value= " + c.readValue() + "\n");
			}

			else if (choice == 2) {
				c.decrement();
				System.out.println("\n Value= " + c.readValue() + "\n");
			}

			else if (choice == 3) {
				System.out.println("\n Value= " + c.readValue() + "\n");
			}

		} // end while

	}

}
