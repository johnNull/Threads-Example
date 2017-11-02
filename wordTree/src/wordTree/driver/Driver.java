package wordTree.driver;
import wordTree.util.FileProcessor;
import wordTree.store.Results;
import wordTree.trees.TreeManager;
import wordTree.threadMgmt.PopulateThread;
import wordTree.threadMgmt.DeleteThread;
import wordTree.threadMgmt.CreateWorkers;

public class Driver {
	public static void main(String[] args) {
		if(args == null || args.length < 3)
			throw new IllegalArgumentException("Invalid arguments");
		else{	
			FileProcessor fp = new FileProcessor(args[0]);
			TreeManager bst = new TreeManager();
			Results r = new Results(args[1]);
			PopulateThread pt = new PopulateThread(fp, r, bst);
			Thread t = new Thread(pt);
			t.start();
			String line = "";
			/*System.out.println(fp.readWord());
			while(line != null){
				line = fp.readLine();
				System.out.println(line);
			}*/
		}
	}
}
