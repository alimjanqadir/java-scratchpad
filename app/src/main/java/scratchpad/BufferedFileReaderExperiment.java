package scratchpad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public final class BufferedFileReaderExperiment {
	public static String read(String fileName) {
		try(BufferedReader in = new BufferedReader(
			new FileReader(fileName))){
			return in.lines()
				.collect(Collectors.joining("\n"));
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(read("ArbitraryCodes.java"));
	}
}
