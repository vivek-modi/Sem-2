package Visitor.Q1;

interface Visitor {
	public void visit(Visitable v);
}

interface Visitable {
	public void accept(Visitor v);
}

class Counter implements Visitable {
	private int value;

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Counter(int v) {
		value = v;
	}

	public boolean decrement() {
		if (value > 0) {
			this.value--;
			return true;
		} else
			return false;
	}

	public int readValue() {
		return value;
	}

	public void setValue(int v) {
		value = v;
	}

	public void print_details() {
		System.out.println("Counter Details:");
		System.out.println("Value: " + value);
	}
}