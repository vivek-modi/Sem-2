package Pattern.Decorator.Q2;

public class LowWarning extends Decorator {

	public LowWarning(Counter cc) {
		super(cc);
	}

	public int readValue() {
		return counter.readValue();
	}

	public void decrement() {
		if (counter.readValue() <= 2)
			System.out.println("WARNING GETTING LOW");
		else
			counter.decrement();
	}

	public void increment() {
		counter.increment();
	}

}
