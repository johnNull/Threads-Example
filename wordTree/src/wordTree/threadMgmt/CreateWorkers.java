package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.trees.TreeManager;
import wordTree.store.Results;

public class CreateWorkers {
	FileProcessor fp;
	TreeManager tm;
	Results r;
	PopulateThread[] pts;
	DeleteThread[] dlts;

	public CreateWorkers(FileProcessor f, TreeManager t, Results r1, int nt, String[] dltwords){
		fp = f;	
		tm = t;
		r = r1;
		pts = new PopulateThread[nt];
		dlts = new DeleteThread[nt];
		for(int i = 0; i < nt; i++){
			pts[i] = new PopulateThread(fp, r, tm);
			dlts[i] = new DeleteThread(fp, r, tm, dltwords[i]);
		}
	}

	public void startPopulateWorkers(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		//Create threads
		for(int i = 0; i < pts.length; i++){
			threads.add(new Thread(pts[i]));
			threads.get(i).start();
		}
		
		//Wait for threads to finish
		for(int i = 0; i < pts.length; i++){
			threads.get(i).join();
		}
	}

	public void startDeleteWorkers(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		//Create threads
		for(int i = 0; i < dlts.length; i++){
			threads.add(new Thread(dlts[i]));
			threads.get(i).start();
		}
		
		//Wait for threads to finish
		for(int i = 0; i < dlts.length; i++){
			threads.get(i).join();
		}
	}
}
