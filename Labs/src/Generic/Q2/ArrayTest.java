package Generic.Q2;

class ArrayTest<T extends Comparable<T>> {
	private T[] values;

	public ArrayTest(T[] v) {
		values = v;
	}

	public T first() throws Exception {
		if (values.length == 0)
			throw new Exception();
		return values[0];
	}

	public T max() throws Exception {
		if (values.length == 0)
			throw new Exception();
		T res = values[0];
		for (int i = 0; i < values.length; i++) {
			if (res.compareTo(values[i]) < 0)
				res = values[i];
		}
		return res;
	}

	public void printAll() {
		System.out.println();
		System.out.print("[");
		for (int i = 0; i < values.length; i++)
			System.out.print("  " + values[i]);
		System.out.println("]");
	}
}
