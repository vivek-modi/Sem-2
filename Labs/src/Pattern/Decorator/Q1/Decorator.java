package Pattern.Decorator.Q1;

class Decorator extends Counter {
	protected Counter counter;

	public Decorator(Counter cc) {
		super();
		counter = cc;
	}
}
