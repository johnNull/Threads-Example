package wordTree.store;

import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;
import wordTree.util.MyLogger;
import java.io.PrintWriter;
import java.io.IOException;
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String result = "", directory;
	/**
	 * Constructor for Results, sets output.txt directory
	 */
	public Results(String dir){
		MyLogger.writeMessage("Creating Results instance", MyLogger.DebugLevel.CONSTRUCTOR);
		directory = dir;
	}

	/**
	 * Write the sum and test results to specified file<p>
	 * https://stackoverflow.com/questions/2885173/<p>
	 * how-do-i-create-a-file-and-write-to-it-in-java
	 */	
	public void writeToFile(){
		try{
			MyLogger.writeMessage("Creating/finding output file", MyLogger.DebugLevel.IN_RESULTS);
			if(directory != null && directory.contains(".txt")){
				PrintWriter writer = new PrintWriter(directory, "UTF-8");
				writer.println(result);
				writer.close();
			}
			else
				System.err.format("No output file specified");
		}
		catch(IOException e){
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Write the sum and test results to specified file
	 */
	public void writeToStdout(){
		System.out.println(result);
	}
	
	/**
	 *Add test results to result string
	 */
	public void append(String s){
		result += s;
	}
}
