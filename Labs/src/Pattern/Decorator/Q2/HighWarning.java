package Pattern.Decorator.Q2;

public class HighWarning extends Decorator {

	public HighWarning(Counter cc) {
		super(cc);
	}

	public int readValue() {
		return counter.readValue();
	}

	public void decrement() {
		counter.decrement();
	}

	public void increment() {
		if (counter.readValue() >= 8)
			System.out.println("WARNING GETTING HIGH");
		else
			counter.increment();
	}

}
