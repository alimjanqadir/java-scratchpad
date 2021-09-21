package scratchpad;

import java.util.Map;

public final class ArbitraryCodes {
	public static int classScope = 45;
	public Map<Integer, String> map = Map.of(1, "a", 2, "b");
	public static void main(String[] args) {
		einstienFloorProblem();	
		isMultipleOfThreeAndFive_and_greaterThanTen();
		calculateInterest();
		fibonacciSeries();
		classScopeTest();
		fib(10);

		ArbitraryCodes code = new ArbitraryCodes();
		System.out.println(code.map);
	}	

	static void einstienFloorProblem() {
		System.out.println("einestienFloorProblem");
		for(int i=1; i<=1000; i++) {
			if(i % 2 == 1 && i % 3 == 2 && i % 7 == 0){
				System.out.println(String.format("%d", i));
			}
		}
	}

	static void isMultipleOfThreeAndFive_and_greaterThanTen() {
		System.out.println("isMultipleOfThreeAndFive_and_greaterThanTen");
		int x = 6;
		if (x % 3 == 0 || x % 5 == 0) {
			boolean isGreaterThanTen = x > 10 ? true : false;
		       	if (isGreaterThanTen) {
				System.out.println("Greater than 10.");
			}else {
				System.out.println("Smaller than 10");
			}
		}	
	}

	static void calculateInterest() {
		double ratio = 0.1, initialDeposit = 100, balance = initialDeposit;
		int years = 0;
		var multiple = 2;

		while(balance / initialDeposit < multiple) {
			years += 1;
			balance = balance * (1 + ratio);
		}
		System.out.println(String.format("Takes %d years.", years));
	}

	static void fibonacciSeries() {
		int a=1, b=1, c=0;
		while(c < 100) {
			System.out.println(a);
			System.out.println(b);
			c = a + b;
			b = b + c;
			a = c;
		}
	}

	static void classScopeTest() {
		double classScope = 2.0f;
		System.out.println(classScope);
		{
			double pi = 3.14159265;	
			System.out.println(pi);
		}

	}

	static void fib(int n) {
		var a = 1;
		var b = 1;
		var c = 0;
		for(var i=0; i<n>>>1; i++) {
			System.out.printf("%d %d ", a, b);
			c = a+b;
			b = b+c;
			a = c;
		}
		System.out.print("\n");
	}
}
