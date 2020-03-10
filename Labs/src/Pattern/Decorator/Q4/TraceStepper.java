package Pattern.Decorator.Q4;

public class TraceStepper extends Decorator {

	public TraceStepper(Stepper st) {
		super(st);
	}

	public void stepUp(int amt) {
		stepper.stepUp(amt);
	}

	public void stepDown(int amt) {
		stepper.stepDown(amt);
	}

	public int readValue() {
		return stepper.readValue();
	}

}
