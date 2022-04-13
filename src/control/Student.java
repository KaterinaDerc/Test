package control;

public class Student {

	private String name;
	private int age;
	private int well;
	private int cart;

	public Student(String name, int age, int well, int cart) {
		this.name = name;
		this.age = age;
		this.well = well;
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getWell() {

		return well;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setWell(int well) {
		this.well = well;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public String toString() {
		return name + "" + age + "" + well;
	}

	public String getFullDescription() {
		return name + "|" + age + "|" + well + "|" + cart;
	}

}
