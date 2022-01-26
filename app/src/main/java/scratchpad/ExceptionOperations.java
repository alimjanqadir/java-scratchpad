import java.io.StringWriter;
import java.io.PrintWriter;

public final class ExceptionOperations {
	public static String stackTraceAsString(Throwable throwable) {
		var stringWriter = new StringWriter();
		throwable.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}
	
}
