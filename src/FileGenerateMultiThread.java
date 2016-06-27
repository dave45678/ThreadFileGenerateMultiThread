import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileGenerateMultiThread {
	public static void main(String[] args) {
		System.out.println("Number of Active Threads**: " + Thread.activeCount());
		long startTime = System.currentTimeMillis();
		try {
			Path filePath = Paths.get("customers.txt");
			File sourcefile = filePath.toFile();
			BufferedReader reader = new BufferedReader (new FileReader(sourcefile));
	
			String line = reader.readLine();
			
			while (line != null) {
					new IOTask(line).start();
					line = reader.readLine();
			}
			System.out.println("Number of Active Threads: " + Thread.activeCount());
					
			//while(Thread.activeCount()!=1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "(ms)");
	}

}
