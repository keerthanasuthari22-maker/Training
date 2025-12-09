package abc;

public class Demo {
	void add() {
		System.out.println("I am from  add method "+(2+3));
	}

	public static void main(String[] args) {
		Demo dd = new Demo();
		dd.add();
		System.out.println("I am from  "+(2+3));
	}

}