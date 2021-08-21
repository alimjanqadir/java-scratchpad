package scratchpad;

import org.junit.jupiter.api.*;

public class MathOperationsTest {
	private static MathOperations mathOperations;

	@BeforeAll
	public static void setup() {
		mathOperations = new  MathOperations();
	}

	@Test
	public void average() {
		var result = mathOperations.average(new int[]{1, 2, 3, 4});
		Assertions.assertEquals(result, 2.5);		
	}
	
	@Test
	public void whenAverageReceivesEmptyArrayExceptionWouldThrown_thenAssertionSucceds() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			var result = mathOperations.average(new int[]{});
		});
		
		Assertions.assertTrue("Array is empty".contains(exception.getMessage()));
	}
	
	@Test
	public void gcd() {
		var result = mathOperations.gcd(new int[]{10, 100});
		Assertions.assertEquals(10, result.getAsInt());
	}
}

