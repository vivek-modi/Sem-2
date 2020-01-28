package Thread.Q1;

class Display1 implements Runnable {
	public String name;

	public Display1(String nm) {
		name = nm;
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(name + ": " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

public class Q1Skel2 {
	public static void main(String[] args) {
		Display1 d1 = new Display1("First");
		Display1 d2 = new Display1("Second");
		Thread t1 = new Thread(d1);
		t1.start();
		Thread t2 = new Thread(d2);
		t2.start();
	}
}
