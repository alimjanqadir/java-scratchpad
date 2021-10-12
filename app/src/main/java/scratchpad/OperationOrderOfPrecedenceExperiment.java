package scratchpad;

public class OperationOrderOfPrecedenceExperiment {

	public static void main(String[] args) {
		orderOfPrecedenceTest1();
		orderOfPrecedenceTest2();
	}

	static void orderOfPrecedenceTest1() {
		int a = 1, b, c;
		a = b = a++;
		c = a++ + b;
		System.out.println("a: " + a + " b: " + b);
	}

	static void orderOfPrecedenceTest2() {
		int a = 2, b = 2, c = 2;
		a = b + c++ - a; // a = 2
		b = a * c++; // b = 6
		c = b - ++a; // a = 3 c = 3
		System.out.println(a + b); // 9
	}
}
