package Thread.Q2;

public class Q2 {
	public static void main(String[] args) {
		Incrementer i = new Incrementer();
		i.start();
		Decrementer d = new Decrementer();
		d.decrementer();
	}
}

/**************************************/

class Incrementer extends Thread {
	public void run() {
		for (int i = 1; i <= 6; i++) {
			System.out.println("Incrementer: " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

/**************************************/

class Decrementer {
	public void decrementer() {
		for (int i = 6; i > 0; i--) {
			System.out.println("Decrementer: " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
