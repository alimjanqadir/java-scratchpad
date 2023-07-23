package scratchpad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileInputStreamPractice {
	public static void main(String[] args) {
		var projectRootPath = new File("../../../../../object.data");
		try {
			var fileInputStream = new FileInputStream(projectRootPath);
			while(fileInputStream.available() > 0) {
				System.out.print((char) fileInputStream.read());
			}
			fileInputStream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
