package Visitor.Q1;

public class MoreFunctions implements Visitor {

	private Counter counter;

	@Override
	public void visit(Visitable v) {
		counter = (Counter) v;
	}

	public void increment() {
		int CurrentValue = counter.readValue();
		CurrentValue++;
		counter.setValue(CurrentValue);
	}

}
