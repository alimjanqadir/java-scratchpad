package scratchpad;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
}
