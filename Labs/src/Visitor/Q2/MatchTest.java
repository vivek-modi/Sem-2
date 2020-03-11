package Visitor.Q2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Match m = new Match();
		MoreFunctions functions = new MoreFunctions();
		m.accept(functions);
		m.print_score();

		int choice = 1;

		while (choice != 6) {
			System.out.println();
			System.out.println("1.City Score");
			System.out.println("2.United Score");
			System.out.println("3.Print Details");
			System.out.println("4.Restart Match");
			System.out.println("5.Read Result");
			System.out.println("6.Exit");

			System.out.print("Please enter a value-->");
			choice = sc.nextInt();
			if (choice == 1) {
				m.team1_score();
				m.print_score();

			}

			else if (choice == 2) {
				m.team2_score();
				m.print_score();

			}

			else if (choice == 3) {
				m.print_score();
			}

			else if (choice == 4) {
				functions.restartMatch();
				m.print_score();

			}

			else if (choice == 5) {
				System.out.println("" + functions.readResult());
			}

		}

	}

}
