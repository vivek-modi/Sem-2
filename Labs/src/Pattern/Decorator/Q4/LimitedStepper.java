package Pattern.Decorator.Q4;

public class LimitedStepper extends Decorator {

	public LimitedStepper(Stepper ss) {
		super(ss);
	}

	public void stepUp(int amt) {
		if (amt + stepper.readValue() > 100) {
			System.out.println("error not allowed to exceed 100");
		} else {
			stepper.stepUp(amt);
		}
	}

	public void stepDown(int amt) {
		if (amt > stepper.readValue()) {
			System.out.println("error not allowed to below 0");
		} else {
			stepper.stepDown(amt);
		}
	}

	public int readValue() {
		return stepper.readValue();
	}
}
