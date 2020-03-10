package Pattern.Decorator.Q3;

public class LowerLine extends Decorator {

	public LowerLine(Display ds) {
		super(ds);
	}

	public void update(String n) {
		display.update(n);
	}

	public void print() {
		display.print();
		for (int i = 0; i < display.name.length(); i++) {
			System.out.print("*");
		}
	}

}
