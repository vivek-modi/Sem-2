package Generic.Q12;

import java.util.Iterator;
import java.util.LinkedList;

class ListFunctions {

	public static void printlist(LinkedList<Node> list) {
		Node temp;
		Iterator<Node> iter = list.iterator();
		System.out.println("\nList:");
		System.out.print("HEAD->");
		while (iter.hasNext()) {
			temp = (Node) iter.next();
			temp.print();
		}

		System.out.print("NULL");
	}

	public static boolean searchName(LinkedList<Node> list, String name) {
		Node temp;
		Iterator<Node> iter = list.iterator();
		while (iter.hasNext()) {
			temp = (Node) iter.next();
			if (name.equals(temp.readname()))
				return true;
		}
		return false;
	}

	public static int countOccurs(LinkedList<Node> list, String name) {
		Node temp;
		int count = 0;
		Iterator<Node> iter = list.iterator();
		while (iter.hasNext()) {
			temp = (Node) iter.next();
			if (name.equals(temp.readname()))
				count++;
		}
		return count;
	}

}
