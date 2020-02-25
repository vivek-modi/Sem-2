package Generic.Q12;

class Node<T> {
	private T name;
	private T age;
	public Node next;

	public T readname() {
		return name;
	}

	public T readage() {
		return age;
	}

	public Node(T nm, T a) {
		name = nm;
		age = a;
	}

	public void print() {
		System.out.print("[" + name + ":" + age + "]-->");
	}
}
