package scratchpad;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public final class InputStreamReaderPractice {

	public static void main(String[] args) {
		File filePath = new File("FileInputStreamPractice.java");
		if(filePath.exists()) {
			try {
				var fileInputStream = new FileInputStream(filePath);
				var reader = new InputStreamReader(fileInputStream);
				var bufferedReader = new BufferedReader(reader);
				String line;
				while((line = bufferedReader.readLine()) != null){
					System.out.println(line);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
}
