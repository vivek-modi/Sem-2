package Pattern.Decorator.Q4;
import java.util.Scanner;

public class StepperTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stepper m = new LimitedStepper(new TraceStepper(new Stepper()));

		int choice = 1;

		while (choice != 5) {
			System.out.println();
			System.out.println("1.Step Up");
			System.out.println("2.Step Down");
			System.out.println("3.Read Value");
			System.out.println("4.Exit");

			System.out.print("Please enter a value-->");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("Enter Amount: ");
				m.stepUp(sc.nextInt());
				System.out.println("\n Value= " + m.readValue() + "\n");
			}
			else if (choice == 2) {
				System.out.print("Enter Amount: ");
				m.stepDown(sc.nextInt());
				System.out.println("\n Value= " + m.readValue() + "\n");
			}

			else if (choice == 3) {
				System.out.println("\n Value= " + m.readValue() + "\n");
			}

		} // end while

	}

}
