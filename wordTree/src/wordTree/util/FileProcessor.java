package wordTree.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import wordTree.store.Results;

public class FileProcessor{
	BufferedReader reader;
	File file;
	/**
	 * Constructor. Takes in directory and ensures the file exists.<p>
	 * https://www.programcreek.com/2011/03/<p>
	 * java-read-a-file-line-by-line-code-example/
	 */
	public FileProcessor(String dir, Results r){
		//Output debug message
		r.writeToScreen("Creating FileProcessor", MyLogger.DebugLevel.CONSTRUCTOR);
		
		//Set input file
		file = new File(dir);
		if(file.exists()){		
			try{
				reader = new BufferedReader(new FileReader(file));
			}
			catch(IOException e){
				System.err.format("IOException: %s%n", e);
			}
		}
		else{
			System.out.println("File does not exist");
		}
	}

	/**
	 * Returns the next word in the text file. ensures file exists
	 * @return The next line in the text file
	 */
	public synchronized String readWord(){
		String word = "";
		int temp = 0;
		if(file.exists()){
			try{
				temp = reader.read();
				while((char)temp != ' ' && (char)temp != '\n'){
					//System.out.println((char)temp);
					if(temp != -1)
						word += (char)temp;
					else{
						return null;
					}
					temp = reader.read();
				}
				return word;
			}
			catch(IOException e){
				System.err.format("IOException: %s%n", e);
			}
		}
		else{
			//System.out.println("No file to be read");
			return null;
		}
		return null;
	}

	/**
	 * Returns the next line in the text file. ensures file exists
	 * https://www.programcreek.com/2011/03/<p>
	 * java-read-a-file-line-by-line-code-example/<p>
	 * @return The next line in the text file
	 */
	public synchronized String readLine(){
		String line = "";
		if(file.exists()){
			try{
				line = reader.readLine();
				if(line != null)
					return line;
				else{
					return null;
				}
			}
			catch(IOException e){
				System.err.format("IOException: %s%n", e);
			}
		}
		else{
			System.out.println("No file to be read");
			return null;
		}
		return null;
	}
}
