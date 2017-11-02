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
		for(int i = 0; i < pts.length; i++){
			Thread t = new Thread(pts[i]);
			t.start();
		}
	}

	public void startDeleteWorkers(){
		for(int i = 0; i < dlts.length; i++){
			Thread t = new Thread(dlts[i]);
			t.start();
		}
	}
}
