package scratchpad;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public static boolean isInnerClass(Class<?> cls) {
		return cls != null && cls.getEnclosingClass() != null;
	}

	public static void main(String[] args) {
		ReflectionPractice.getAllInterfaces(FileInputStream.class)
			.stream()
			.forEach(System.out::println);
	}

}
