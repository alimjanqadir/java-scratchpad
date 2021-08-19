package scratchpad;

import java.util.stream.IntStream;

public class MathOperations {
	public double average(int[] array) {
		return IntStream.of(array)
				.average()
				.orElseThrow(() -> new IllegalArgumentException("Array is empty"));				
	}
}

