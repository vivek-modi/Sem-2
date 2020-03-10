package Pattern.Decorator.Q3;

public class UpperLine extends Decorator {

	public UpperLine(Display n) {
		super(n);
	}

	public void update(String n) {
		display.update(n);
	}

	public void print() {
		for (int i = 0; i < display.name.length(); i++) {
			System.out.print("*");
		}
		display.print();

	}

}
