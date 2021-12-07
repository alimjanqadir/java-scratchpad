package scratchpad;

import java.lang.*;
import java.util.*;

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
}
