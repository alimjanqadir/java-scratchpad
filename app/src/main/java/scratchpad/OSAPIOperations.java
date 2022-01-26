import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
public final class OSAPIOperations {
	public static boolean isDebuggerAttached() {
		var runtimeMXBean = ManagementFactory.getRuntimeMXBean();	
		return runtimeMXBean.getInputArguments()
			.stream()
			.anyMatch(arg -> arg.contains("-agentlib:jdwp"));
	}
}
