import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOTask extends Thread {
	private String customerName;
	public IOTask(String customerName) {
		this.customerName = customerName;
	}
	
	@Override
	public void run() {

		String content = "Thank you for giving us the opportunity to serve your company " +  
                "for the past two years. We want you to know that we have "+
			"appreciated your business and your prompt payments. Your cooperation has helped " +
                "our business run smoothly and has led to a respectful business relationship " +
			" between our two companies. We look forward to many more years of mutually "+
                "  beneficial association and wish your company the success that it deserves";
	try {
		String filepath = "files/" + customerName + ".txt";
		File fileObj = Paths.get(filepath).toFile();
		PrintWriter writer = new PrintWriter(new BufferedWriter (new FileWriter(fileObj)));
		writer.println("Transaction History");
		writer.println("*******************");
		writer.println("Dear " + customerName + ",");
		writer.println(content);
		writer.println("Transaction Details");
		for(int i=0; i <10000; i++) {
			writer.println("Transaction#: " + i);
		}
		writer.println("Thank you for being a great customer.");
		writer.flush();
		writer.close();
		
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}

	}

}
