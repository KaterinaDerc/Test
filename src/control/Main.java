package control;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	//some comments
	
	//some comments2
	
	static ArrayList<Students> studentList = new ArrayList<>();

	static Scanner scanner;

	@SuppressWarnings("unused")
	private static Object cart;

	public static void main(String args[]) {
		initArray();

		scanner = new Scanner(System.in).useDelimiter("\n");

		int command = 0;

		while (command != 5) {

			printMenu();
			command = getCommand();

			if (command == 1) {
				addStudents();
			} else if (command == 2) {
				deleteStudents(studentList);
			} else if (command == 3) {
				printAllStudent();
			} else if (command == 4) {
				findStudents();
			} else if (command == 6) {
				changeStudents(studentList);
			} else if (command == 5) {
				exitApp();
			} else {
				System.out.println("Unknown command");

			}
		}

		scanner.close();

	}

	static void initArray() {
		studentList.add(new Students("Dima", 20, 2, 2020));
		studentList.add(new Students("Tolia", 20, 1, 2021));
		studentList.add(new Students("Lilia", 18, 1, 2021));

	}

	static void printMenu() {
		System.out.println("");
		System.out.println("Select command:");
		System.out.println("1 - add student");
		System.out.println("2 - delete student");
		System.out.println("3 - print all students");
		System.out.println("4 - find student");
		System.out.println("6- change students");
		System.out.println("5 - exit");

		@SuppressWarnings({ "unused", "resource" })
		Scanner scanner = new Scanner(System.in);
	}

	public static int getCommand() {
		System.out.println("Enter command:");
		int command;
		if (scanner.hasNext()) {
			command = scanner.nextInt();
		} else {
			System.out.println("Error, try again");
			scanner.next();
			command = getCommand();
		}
		return command;
	}

	public static void addStudents() {

		System.out.println("Enter name: ");

		String name = scanner.hasNext() ? scanner.next() : "";

		System.out.println("Enter well: ");

		int well = scanner.hasNext() ? scanner.nextInt() : 0;

		System.out.println("Enter age: ");

		int age = scanner.hasNext() ? scanner.nextInt() : 0;

		System.out.println("Enter number cart");

		int cart = scanner.hasNext() ? scanner.nextInt() : 0;

		Students s2 = new Students(name, age, well, cart);

		studentList.add(s2);
	}

	static void printAllStudent() {
		System.out.println("Student list:");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println((i + 1) + "|" + studentList.get(i).getFullDescription());
		}
	}

	static void deleteStudents(ArrayList<Students> array) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the card number of the student to be deleted:");
		int cart = in.nextInt();

		int positionForDelete = -1;

		for (int x = 0; x < studentList.size(); x++) {

			Students s = studentList.get(x);
			if (cart == s.getCart()) {
				positionForDelete = x;
				break;
			}

		}

		if (positionForDelete == -1) {

			System.out.println("Not found");
		} else {
			System.out.println("Deleted");
			studentList.remove(positionForDelete);

		}

	}

	public static void findStudents() {

		System.out.print("Enter number cart");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int cart = in.nextInt();
		@SuppressWarnings("unused")
		int cartNumber = cart;
		@SuppressWarnings({ "unused", "resource" })
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		@SuppressWarnings("unused")
		int size = 0;

		for (int i = 0; i < studentList.size(); i++) {

			if (studentList.get(i).getCart() == cart) {

				System.out.print((studentList.get(i).getFullDescription()));
				break;
			}

		}
	}

	public static void changeStudents(ArrayList<Students> studentList2) {

		System.out.print("Enter number cart for change student details");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int cart = in.nextInt();
		@SuppressWarnings("unused")
		int cartNumber = cart;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in).useDelimiter("\n");
		@SuppressWarnings("unused")
		int size = 0;

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getCart() == cart) {

				System.out.print("Enter new name:");
				@SuppressWarnings({ "unused", "resource" })
				Scanner in1 = new Scanner(System.in);
				@SuppressWarnings({ "unused", "resource" })
				Scanner scanner1 = new Scanner(System.in).useDelimiter("\n");

				String name1 = scanner.hasNext() ? scanner.nextLine() : "";

				studentList.get(i).setName(name1);

				System.out.print("Enter new age:");

				int age = scanner.hasNext() ? scanner.nextInt() : 0;

				studentList.get(i).setAge(age);

				System.out.println("Enter new well");
				int well = scanner.hasNext() ? scanner.nextInt() : 0;
				studentList.get(i).setWell(well);
				System.out.println("Enter cart");
				@SuppressWarnings({ "unused", "resource" })
				Scanner in4 = new Scanner(System.in);
				@SuppressWarnings({ "unused", "resource" })
				Scanner scanner4 = new Scanner(System.in).useDelimiter("\n");
				int cart1 = scanner.hasNext() ? scanner.nextInt() : 0;

				studentList.get(i).setCart(cart1);

				break;
			}

		}

	}

	static void exitApp() {
		System.out.println("Goodbuy");
	}
}