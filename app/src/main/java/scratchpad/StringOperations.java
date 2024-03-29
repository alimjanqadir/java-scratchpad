package scratchpad;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringOperations {
	public int byteSize(String input) {
		return input.getBytes().length;
	}

	public String capitalize(String input, boolean lowerRest) {
		return input.substring(0,1).toUpperCase() +
			(lowerRest
			 	? input.substring(1, input.length()).toLowerCase()
				: input.substring(1, input.length())
			);
	}

	public String capitalizeEveryWord(String input) {
		return Pattern.compile("\\b(?=\\w)").splitAsStream(input)
			.map(w->capitalize(w, false))
			.collect(Collectors.joining());
	}

	public int countVowels(String input) {
		return input.replaceAll("[^aioueAIOUE]", "").length();
	}

	public String escapeRegExp(String input) {
		return Pattern.quote(input);
	}

	public String fromCamelCase(String input, String separator) {
		return input
			.replaceAll("([a-z\\d])([A-Z])", "$1" + separator + "$2")
			.toLowerCase();
	}

	public boolean isAbsoluteUrl(String url) {
		return Pattern.compile("^[a-z][a-z0-9.+-]*:").matcher(url).find();
	}

	public boolean isLowerCase(String input) {
		return Objects.equals(input, input.toLowerCase());
	}

	public boolean isPalindrome(String input) {
		var processed = input.toLowerCase().replaceAll("[\\W_]", "");
		var reversed = new StringBuilder(processed).reverse().toString();
		return reversed.equals(processed);
	}

	public boolean isNumeric(String input) {
		return IntStream.range(0, input.length())
			.allMatch(i-> Character.isDigit(input.charAt(i)));
	}

	public String reveseString(String input) {
		return new StringBuilder(input).reverse().toString();
	}

	public String[] splitLines(String input) {
		return input.split("\\r?\\n");
	}

	public String sortCharactersInString(String input) {
		return Arrays.stream(input.split("")).sorted().collect(Collectors.joining());
	}

	public int[] convertStringToInts(String input) {
		return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
	}

	public String truncateString(String input, int num) {
		return input.length() > num ?
			input.substring(0, num > 3 ? num - 3 : num ) :
			input;
	
	}

	public String[] words(String input) {
		return Arrays.stream(input.split("[^a-zA-z]+"))
			.filter(s->!s.isEmpty())
			.toArray(String[]::new);
	}
}
