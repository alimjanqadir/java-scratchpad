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
	
	@Test
	public void lcm() {
		var result = mathOperations.lcm(new int[]{4, 8});
		Assertions.assertEquals(8, result.getAsInt());
	}

	@Test
	public void isEven() {
		var result = mathOperations.isEven(2);
		Assertions.assertEquals(true, result);
		
	}

	@Test
	public void getNextPositiveBinaryStructure() {
		var result = mathOperations.getNextPositiveBinaryStructure(50);
		Assertions.assertEquals(Integer.toBinaryString(64), result);
	}

	@Test
	public void isPowerOfTwo() {
		var result = mathOperations.isPowerOfTwo(16);
		Assertions.assertEquals(true, result);
	}
}


