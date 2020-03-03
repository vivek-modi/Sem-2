package Pattern.Q2;

class Outing {
	protected int count;
	private static Outing INSTANCE;
	protected int max;

	public Outing() {
		this.count = 0;
		this.max = 20;
	}

	public boolean cancel() {
		if (count > 0) {
			this.count--;
			return true;
		} else
			return false;
	}

	public boolean add() {
		if (count < max) {
			this.count++;
			return true;
		} else
			return false;
	}

	public int readCount() {
		return count;
	}

	public int readMax() {
		return max;
	}

	public void print_details() {
		System.out.println();
		System.out.println("Outing Details:");
		System.out.println("Number on Outing: " + count);
	}

	public static Outing getInstance() {
		return (INSTANCE == null) ? INSTANCE = new Outing() : INSTANCE;
	}

}