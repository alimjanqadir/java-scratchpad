package scratchpad;

public final class ArbitraryCodes {
	public static void main(String[] args) {
		einstienFloorProblem();	
		isMultipleOfThreeAndFive_and_greaterThanTen();
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
}
