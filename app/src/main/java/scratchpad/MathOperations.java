package scratchpad;

import java.util.stream.IntStream;
import java.util.OptionalInt;
import java.util.Arrays;

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
}


