package wordTree.driver;
import wordTree.util.FileProcessor;

public class Driver {
	public static void main(String[] args) {
		if(args == null || args.length < 3)
			throw new IllegalArgumentException("Invalid arguments");
		else{	
			FileProcessor fp = new FileProcessor(args[0]);
			String word = "";
			while(word != null){
				word = fp.readWord();
				System.out.println(word);
			}
		}
	}
}
