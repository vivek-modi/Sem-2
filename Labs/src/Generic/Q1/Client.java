package Generic.Q1;

class Client {
	public static void main(String[] args) {
		Counter<Integer> ci = new Counter<Integer>(2);
		System.out.println("Res=" + ci.readValue());
		ci.updateValue(5);
		System.out.println("Res post set =" + ci.readValue());
		
		Counter<Double> cout = new Counter<Double>(2.0);
		System.out.println("Res=" + cout.readValue());
		cout.updateValue(5.0);
		System.out.println("Res post set =" + cout.readValue());
	}
}
