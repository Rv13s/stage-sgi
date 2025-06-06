package utils;

import java.nio.file.Paths;

public class FileUtil {
	
	
	
	public static String  getTestFilePath(String fileName) {
		
		
		// This assumes your files are stored at src/test/resources/testfiles/
		return Paths.get("src","test","resources","testfiles", fileName)
				.toAbsolutePath().toString();
		
	}

}
