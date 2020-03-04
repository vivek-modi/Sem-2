package Pattern.Decorator.Q2;

class Decorator extends Counter {
	protected Counter counter;

	public Decorator(Counter cc) {
		super();
		counter = cc;
	}
}
