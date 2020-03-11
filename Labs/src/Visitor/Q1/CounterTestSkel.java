package Visitor.Q1;

import java.util.Scanner;

public class CounterTestSkel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Counter c = new Counter(20);
		MoreFunctions functions = new MoreFunctions();
		c.accept(functions);

		c.print_details();

		int choice = 5;

		while (choice != 4) {
			System.out.println("\nCounter Application");
			System.out.println("===================");
			System.out.println("1.Increment");
			System.out.println("2.Decrement");
			System.out.println("3.Print Details");
			System.out.println("4.Exit");

			System.out.print("Please enter a value-->");
			choice = sc.nextInt();
			if (choice == 1) {
				functions.increment();
				c.print_details();
			}

			if (choice == 2) {
				boolean res1 = c.decrement();
				if (res1 == false)
					System.out.println("Error");

				c.print_details();
			}

			else if (choice == 3) {
				c.print_details();
			}

		} // end while
	}

}