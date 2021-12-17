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

	@Test
	public void fromCamelCase(){
		var input = "camelCase";
		var result = testTarget.fromCamelCase(input, "_");
		assertEquals(result,"camel_case");
	}

	@Test
	public void isAbsoluteUrl_with_false_input_and_should_fail() {
		var input = "../test";
		var result = testTarget.isAbsoluteUrl(input);
		assertEquals(result, false);
	}
	
	@Test
	public void isAbsoluteUrl_with_tur_input_and_should_success() {
		var input = "https://example.com";
		var result = testTarget.isAbsoluteUrl(input);
		assertEquals(result, true);
	}

	@Test
	public void isLowerCase_should_success() {
		var input = "test";
		var result = testTarget.isLowerCase(input);
		assertEquals(result, true);
	}

	@Test
	public void isLowerCase_should_fail() {
		var input = "Test";
		var result = testTarget.isLowerCase(input);
		assertEquals(result, false);
	}

	@Test
	public void isPalinedrome_should_suceess() {
		var input = "tenet";
		var result = testTarget.isPalindrome(input);
		assertEquals(result, true);
	}
	
	@Test
	public void isPalinedrome_should_fail() {
		var input = "test";
		var result = testTarget.isPalindrome(input);
		assertEquals(result, false);
	}
}
