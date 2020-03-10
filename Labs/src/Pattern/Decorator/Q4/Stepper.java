package Pattern.Decorator.Q4;

public class Stepper {

	private int value;

	public Stepper() {
		value = 0;
	}

	public void stepUp(int amt) {
		value += amt;
	}

	public void stepDown(int amt) {
		value -= amt;
	}

	public int readValue() {
		return value;
	}
}
