package scratchpad;

import java.io.*;

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
