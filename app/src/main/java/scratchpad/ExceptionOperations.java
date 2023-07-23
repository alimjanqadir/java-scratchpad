package scratchpad;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class ExceptionOperations {
	public static String stackTraceAsString(Throwable throwable) {
		var stringWriter = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}
	
}
