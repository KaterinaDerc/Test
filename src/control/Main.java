package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Address;
import model.User;

public class Main {

	static ArrayList<Student> studentList = new ArrayList<>();
	static Scanner scannerforStr;
	static Scanner scannerforInt;

	public static void main(String args[]) throws IOException {
		initArray();
		scannerforInt = new Scanner(System.in).useDelimiter("\n");
		scannerforStr = new Scanner(System.in).useDelimiter("\n");

		int command = 0;

		while (command != 7) {

			printMenu();
			command = getCommand();

			if (command == 1) {
				addStudents();
			} else if (command == 2) {
				deleteStudents();
			} else if (command == 3) {
				printAllStudent();
			} else if (command == 4) {
				findStudents();
			} else if (command == 5) {
				showNetworkUsers();
			} else if (command == 6) {
				changeStudents();
			} else if (command == 7) {
				exitApp();
			} else {
				System.out.println("Unknown command");

			}
		}

		scannerforStr.close();
		scannerforInt.close();
	}

	static void initArray() {
		studentList.add(new Student("Dima", 20, 2, 2020));
		studentList.add(new Student("Tolia", 20, 1, 2021));
		studentList.add(new Student("Lilia", 18, 1, 2021));
	}

	static void printMenu() {
		System.out.println("");
		System.out.println("Select command:");
		System.out.println("1 - add student");
		System.out.println("2 - delete student");
		System.out.println("3 - print all students");
		System.out.println("4 - find student");
		System.out.println("5- show network users");
		System.out.println("6 - change students");
		System.out.println("7 - exit");
	}

	public static int getCommand() {
		System.out.println("Enter command:");
		int command;
		if (scannerforInt.hasNext()) {
			command = scannerforInt.nextInt();
		} else {
			System.out.println("Error, try again");
			scannerforInt.next();
			command = getCommand();
		}
		return command;
	}

	public static void addStudents() {

		System.out.println("Enter name: ");

		String name = scannerforStr.hasNext() ? scannerforStr.next() : "";

		System.out.println("Enter well: ");

		int well = scannerforInt.hasNext() ? scannerforInt.nextInt() : 0;

		System.out.println("Enter age: ");

		int age = scannerforInt.hasNext() ? scannerforInt.nextInt() : 0;

		System.out.println("Enter number cart");

		int cart = scannerforInt.hasNext() ? scannerforInt.nextInt() : 0;

		Student s2 = new Student(name, age, well, cart);

		studentList.add(s2);
	}

	static void printAllStudent() {
		System.out.println("Student list:");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println((i + 1) + "|" + studentList.get(i).getFullDescription());
		}
	}

	static void deleteStudents() {
		System.out.print("Enter the card number of the student to be deleted:");
		int cart = scannerforInt.nextInt();

		int positionForDelete = -1;

		for (int x = 0; x < studentList.size(); x++) {

			Student s = studentList.get(x);
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
		int cart = scannerforInt.nextInt();

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getCart() == cart) {
				System.out.print((studentList.get(i).getFullDescription()));
				break;
			}
		}
	}

	public static void changeStudents() {

		System.out.print("Enter number cart for change student details");
		int cart = scannerforInt.nextInt();

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getCart() == cart) {

				System.out.print("Enter new name:");
				String name1 = scannerforStr.hasNext() ? scannerforStr.nextLine() : "";
				studentList.get(i).setName(name1);
				System.out.print("Enter new age:");
				int age = scannerforInt.hasNext() ? scannerforInt.nextInt() : 0;

				studentList.get(i).setAge(age);

				System.out.println("Enter new well");

				int well = scannerforInt.hasNext() ? scannerforInt.nextInt() : 0;

				studentList.get(i).setWell(well);
				System.out.println("Enter cart");
				int cart1 = scannerforInt.hasNext() ? scannerforInt.nextInt() : 0;

				studentList.get(i).setCart(cart1);

				break;
			}

		}

	}

	public static void showNetworkUsers() throws IOException {

		String studentUrl = "https://jsonplaceholder.typicode.com/users";

		URL url = new URL(studentUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {

			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(inputReader);
			StringBuilder stringBuilder = new StringBuilder();

			String outputFromBuff;
			while ((outputFromBuff = buffer.readLine()) != null) {
				stringBuilder.append(outputFromBuff);

			}

			JSONArray jArray = new JSONArray(stringBuilder.toString());

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject jUser = jArray.getJSONObject(i);

				User user = new User(jUser);
				

				System.out.println(user.getFullDescription());
				//System.out.println(street);

			}
		}

		else {
			System.out.println("no InfoforStudent");
		}

	}

	static void exitApp() {
		System.out.println("Goodbuy");

	}
}
