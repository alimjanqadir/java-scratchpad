package scratchpad;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import scratchpad.StringOperations;


public final class StringOperationsTest {
	private static StringOperations testTarget; 
	
	@BeforeAll
	public static void setup() {
		testTarget = new StringOperations();
	}

	@Test
	public void byteSize(){
		var result = testTarget.byteSize("abc");
		assertEquals(result, 3);
	}

}
