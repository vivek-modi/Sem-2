package Pattern.Decorator.Q1;

public class Counter {

	private int value;

	public Counter() {
		value = 0;
	}

	public void increment() {
		value++;
	}

	public void decrement() {
		value--;
	}

	public int readValue() {
		return value;
	}
}
