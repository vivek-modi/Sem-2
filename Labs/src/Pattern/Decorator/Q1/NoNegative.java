package Pattern.Decorator.Q1;

public class NoNegative extends Decorator {

	public NoNegative(Counter cc) {
		super(cc);
	}

	public void increment() {
		counter.increment();
	}

	public void decrement() {
		if (counter.readValue() == 0)
			System.out.println("Already 0");
		else
			counter.decrement();
	}

	public int readValue() {
		return counter.readValue();
	}

}
