package Pattern.Q1;

class Counter {
	private int value = 0;
	public static Counter single;

	public Counter() {
		value = 0;
	}

	public int readValue() {
		return value;
	}

	public void stepValue() {
		value++;
	}

	public static Counter getInstance() {
		return (single == null) ? single = new Counter() : single;
	}

}

public class TestCounter {
	public static void main(String[] args) {
		Counter c1 = Counter.getInstance();
		Counter c2 = Counter.getInstance();
		c1.stepValue();
		System.out.println("Value= :" + c1.readValue());
		c2.stepValue();
		System.out.println("Value= :" + c2.readValue());
	}
}
