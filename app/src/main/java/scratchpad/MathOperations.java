package scratchpad;

import java.util.stream.IntStream;
import java.util.OptionalInt;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MathOperations {
	public double average(int[] array) {
		return IntStream.of(array)
				.average()
				.orElseThrow(() -> new IllegalArgumentException("Array is empty"));				
	}
	
	public OptionalInt gcd(int[] array) {
		return Arrays.stream(array)
			.reduce((a, b) -> gcd(a, b));
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public OptionalInt lcm(int[] array) {
		return Arrays.stream(array)
			.reduce((a, b) -> (a * b) / gcd(a, b));
	}

	public boolean isEven(int value) {
		return (value & 0b1) == 0;
	}

	public String  getNextPositiveBinaryStructure(int n) {
		var integerResult = 1 << (32 - Integer.numberOfLeadingZeros(n - 1));
		return Integer.toBinaryString(integerResult);
	}

	public int generateRandomInteger() {
		return ThreadLocalRandom.current().nextInt(); 
	}

	public boolean isPowerOfTwo(int value) {
		return value > 0 && (value & (~value + 1)) == value;
	}

	public int log2(int n) {
		var i = 0;
		while(n > 0) {
			n = n >> 1;
			i += 1;
		}
		return i - 1;
	}
}


