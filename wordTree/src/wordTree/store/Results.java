package wordTree.store;

import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.StringBuffer;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private String directory;
	private StringBuffer result = new StringBuffer();
	/**
	 * Constructor for Results, sets output.txt directory
	 * @param dir String specifying containing directory of input file
	 */
	public Results(String dir){
		//Output Debug message
		writeToScreen("Creating Results instance", MyLogger.DebugLevel.CONSTRUCTOR);
		
		//Set directory
		directory = dir;
	}

	/**
	 * Write to specified file<p>
	 * https://stackoverflow.com/questions/2885173/<p>
	 * how-do-i-create-a-file-and-write-to-it-in-java
	 */
	public void writeSchedulesToFile(){
		//Write results string to output file
		try{
			if(directory != null && directory.contains(".txt")){
				PrintWriter writer = new PrintWriter(directory, "UTF-8");
				writer.println(result.toString());
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
	 * Write a message to stdout based on DebugLevel
	 * @param s String message to be written
	 * @param l DebugLevel for when to write message
	 */
	public void writeToScreen(String s, DebugLevel l){
		//Output debug message
		MyLogger.writeMessage(s, l);
	}
	
	/**
	 * Add test results to result String
	 * @param s String to be appended to result String
	 */
	public void append(String s){
		//Append string
		result.append(s);
	}
}
