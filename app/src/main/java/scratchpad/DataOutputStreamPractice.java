package scratchpad;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class DataOutputStreamPractice {
	public static void main(String[] args) {
		var integer = 2147483647;
		var projectRootPath = "../../../../../";
		var outputFile =  new File(projectRootPath + "integer.data");
		try {
			var fileOutputStreamInstance = new FileOutputStream(outputFile);
			var dataOutputStreamInstance = new DataOutputStream(fileOutputStreamInstance);
			dataOutputStreamInstance.writeInt(integer);
			dataOutputStreamInstance.flush();
			dataOutputStreamInstance.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
