package Pattern.Decorator.Q3;

public class Display {

	protected String name;

	public Display(String n) {
		name = n;
	}

	public void update(String n) {
		name = n;
	}

	public void print() {
		System.out.println("Name=" + name);
		
	}

}
