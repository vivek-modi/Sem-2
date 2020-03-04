package Pattern.Decorator.Q1;

public class Limit10Counter extends Decorator {

	public Limit10Counter(Counter cc) {
		super(cc);
	}

	public int readValue() {
		return counter.readValue();
	}

	public void decrement() {
		counter.decrement();
	}

	public void increment() {
		if (counter.readValue() == 10)
			System.out.println("Already 0");
		else
			counter.increment();
	}

}
