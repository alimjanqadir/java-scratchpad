package scratchpad;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.io.IOException;

public final class InputOutputOperations {
	
	public String convertInputStreamToString(InputStream is) throws IOException {
		var os = new ByteArrayOutputStream();
		var buffer = new byte[1024];
		var length = 0;
		while((length = is.read(buffer)) != -1) {
			os.write(buffer, 0, length);
		}
		return os.toString(StandardCharsets.UTF_8.name());
	}

	public String readFileToString(Path path) throws IOException{
		return new String(Files.readAllBytes(path));	
	}

	public String getCurrentWorkingDirectory() {
		return FileSystems.getDefault().getPath("").toAbsolutePath().toString(); 
	}
}

