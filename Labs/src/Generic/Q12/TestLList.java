package Generic.Q12;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TestLList {

	public static void main(String[] args) {

		LinkedList<Node> l = new LinkedList<Node>();
		Scanner sc = new Scanner(System.in);

		String name;
		int age;

		int choice = 0;
		while (choice != 10) {
			System.out.println();
			System.out.println("Menu:");
			System.out.println("1: Insert");
			System.out.println("2: Delete First");
			System.out.println("3: Print_list");
			System.out.println("4: search by Name");
			System.out.println("5: count occurences of Name ");
			System.out.println("6: insert last");
			System.out.println("");
			System.out.println("9: Initialize");
			System.out.println("10: Exit \n");

			System.out.print("Please enter choice-->");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Name:");
				name = sc.next();

				System.out.print("Enter Age:");
				age = sc.nextInt();

				l.addFirst(new Node(name, age));
				break;
			case 2:
				if (l.isEmpty())
					System.out.println("List Empty");
				else {
					Node d = l.removeFirst();
					System.out.println(d.readname() + " deleted");
				}
				break;

			case 3:
				ListFunctions.printlist(l);
				break;

			case 4:
				System.out.print("Enter Name:");
				name = sc.next();

				boolean res1 = ListFunctions.searchName(l, name);
				System.out.println("Found= " + res1);
				break;

			case 5:
				System.out.print("Enter Name:");
				name = sc.next();
				int res2 = ListFunctions.countOccurs(l, name);
				System.out.println("" + name + " occurs in list " + res2 + " times");
				break;

			case 6:
				System.out.print("Enter Name:");
				name = sc.next();

				System.out.print("Enter Age:");
				age = sc.nextInt();
				l.addLast(new Node(name, age));

				break;

			case 9:
				l.addFirst(new Node("A", 5));
				l.addFirst(new Node("B", 15));
				l.addFirst(new Node("C", 4));
				l.addFirst(new Node("D", 8));
				l.addFirst(new Node("B", 25));
				l.addFirst(new Node("B", 20));

				break;

			default:
			}
		}
	}

////////////////////////////////////////////////////////////////

}
