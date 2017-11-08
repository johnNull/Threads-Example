package wordTree.driver;
import wordTree.util.FileProcessor;
import wordTree.store.Results;
import wordTree.trees.TreeManager;
import wordTree.threadMgmt.PopulateThread;
import wordTree.threadMgmt.DeleteThread;
import wordTree.threadMgmt.CreateWorkers;

public class Driver {
	public static void main(String[] args) {
		if(args == null || args.length < 5)
			throw new IllegalArgumentException("Invalid arguments");
		else{	
			Results r = new Results(args[1]);
			FileProcessor fp = new FileProcessor(args[0], r);
			TreeManager bst = new TreeManager(r);
			String[] dltwords = {"quickly", "programmer", "think"};
			CreateWorkers c = new CreateWorkers(fp, bst, r, 3, dltwords);
			c.startPopulateWorkers();
			System.out.println(bst.toString());
			c.startDeleteWorkers();
			System.out.println(bst.toString());
		}
	}
}
