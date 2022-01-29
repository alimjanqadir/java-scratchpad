import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;

public final class ReflectionPractice {
	public static List<Class<?>> getAllInterfaces(Class<?> cls) {
		return Stream.concat(
			Arrays.stream(cls.getInterfaces())
				.flatMap(anInterface -> 
					Stream.concat(
						Stream.of(anInterface),
				       		getAllInterfaces(anInterface).stream())
					),
			cls.getSuperclass() == null ? Stream.empty() 
						    : getAllInterfaces(cls.getSuperclass()).stream()
			)
			.distinct()
			.collect(Collectors.toList());

	}

	public static void main(String[] args) {
		ReflectionPractice.getAllInterfaces(FileInputStream.class)
			.stream()
			.forEach(System.out::println);
	}
}
