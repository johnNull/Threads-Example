package wordTree.driver;

import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.store.Results;
import wordTree.trees.TreeManager;
import wordTree.threadMgmt.PopulateThread;
import wordTree.threadMgmt.DeleteThread;
import wordTree.threadMgmt.CreateWorkers;

public class Driver {
	public static void main(String[] args) {
		//Test args length
		if(args == null || args.length < 5)
			throw new IllegalArgumentException("Invalid arguments");
		else{
			//Test delete words length
			try{
				if(args[3].split(" ").length != Integer.parseInt(args[2]))
					throw new IllegalArgumentException("Num Threads must equal number of delete words");		
			}
			catch(Exception e){
					System.err.println("Incorrect num threads format");
					e.printStackTrace(System.out);
			}
			
			//Set debug level
			try{
				int debug = Integer.parseInt(args[4]);
				if(debug >= 0 && debug <= 4)
					MyLogger.setDebugValue(Integer.parseInt(args[4]));	
				else
					throw new IllegalArgumentException("Debug level must be 0-4");
			}
			catch(Exception e){
				System.err.println("Incorrect debug level format");
				e.printStackTrace(System.out);
			}
			
			//Open input and output files
			Results r = new Results(args[1]);
			FileProcessor fp = new FileProcessor(args[0], r);
			
			//Create TreeManager
			TreeManager bst = new TreeManager(r);
			
			//Create Workers
			CreateWorkers c = new CreateWorkers(fp, bst, r, Integer.parseInt(args[2]), args[3].split(" "));
			
			//Populate Tree
			c.startPopulateWorkers();
			
			//Delete instances of words
			c.startDeleteWorkers();
			
			//Get counts and upload them to Results
			bst.getCounts(r);
			
			//Output results
			r.writeSchedulesToFile();
		}
	}
}
