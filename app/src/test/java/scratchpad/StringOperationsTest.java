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
	
	@Test
	public void capitalize_input_all_lowercase() {
		var input = "test";
		var result = testTarget.capitalize(input, false);
	}

	@Test
	public void capitalizeEveryWord_input_all_lowercase() {
		var input = "this is a test";
		var result = testTarget.capitalizeEveryWord(input);
		assertEquals(result, "This Is A Test");
	}

	@Test
	public void countVowels() {
		var input = "this is a test";
		var result = testTarget.countVowels(input);
		assertEquals(result, 4);
	}
}
