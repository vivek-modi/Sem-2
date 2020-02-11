package DataStructure.Q4;

import java.util.Scanner;

class Node {
	int key;
	String name;
	Node left;
	Node right;

	Node(int k, String nm, Node ll, Node rr) {
		key = k;
		name = nm;
		left = ll;
		right = rr;
	}

	public String readName() {
		return name;
	}
}

public class BSTree {
	private Node head;
	private Node tail;

	public BSTree() {
		tail = new Node(0, null, null, null);
		head = new Node(-1, null, null, tail);
	}

	void insert(int k, String nm) {
		Node p, x;
		p = head;
		x = head.right;
		while (x != tail) {
			p = x;
			x = (k < x.key) ? x.left : x.right;
		}
		x = new Node(k, nm, tail, tail);
		if (k < p.key)
			p.left = x;
		else
			p.right = x;
	}

	void display_tree() {
		System.out.println("\nComplete Tree : ");
		Node t = head.right;
		traverse(t);
	}

	void traverse(Node t) {
		if (t != tail) {
			traverse(t.left);
			visit(t);
			traverse(t.right);
		}
	}

	String search(int key) {
		return "Not Found";
	}

	void visit(Node t) {
		System.out.println(" Node: " + t.key + "  " + t.name);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BSTree t1 = new BSTree();
		t1.insert(5, "peter");
		t1.insert(2, "john");
		t1.insert(10, "martin");
		t1.insert(0, "sean");
		t1.insert(12, "liam");
		t1.insert(7, "mick");
		t1.insert(6, "brian");
		t1.display_tree();

		int choice = 1;
		while (choice != 4) {
			System.out.println("\nMenu");
			System.out.println("==============");
			System.out.println("1.Display Tree");
			System.out.println("2.Insert New Element");
			System.out.println("3.Search for element");
			System.out.println("4.Exit");

			System.out.print("Please enter a value-->");
			choice = sc.nextInt();

			if (choice == 1) {
				t1.display_tree();
			} else if (choice == 2) {
				System.out.print("Enter a new key value(1-100 not already in list:)");
				int k = sc.nextInt();
				System.out.print("Please enter a new name-->");
				String n = sc.next();
				t1.insert(k, n);
			} else if (choice == 3) {
				System.out.print("Please enter a new key value-->");
				int k = sc.nextInt();
				System.out.println("Value found= " + t1.search(k));
			}

		} // end while

	}
}