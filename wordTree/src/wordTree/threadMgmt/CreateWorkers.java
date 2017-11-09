package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.trees.TreeManager;
import wordTree.store.Results;
import java.util.ArrayList;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class CreateWorkers {
	FileProcessor fp;
	TreeManager tm;
	Results r;
	PopulateThread[] pts;
	DeleteThread[] dlts;

	/**
	 * Constructor for CreateWorkers, creates all populate and delete threads
	 * @param f FileProcessor to read input file
	 * @param t TreeManager to set up binary search tree
	 * @param r1 Results instance to print to screen and file
	 * @param nt Number of threads to create
	 * @param dltwords Words to be deleted
	 */
	public CreateWorkers(FileProcessor f, TreeManager t, Results r1, int nt, String[] dltwords){
		r1.writeToScreen("CreateWorkers created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		fp = f;	
		tm = t;
		r = r1;
		pts = new PopulateThread[nt];
		dlts = new DeleteThread[nt];
		for(int i = 0; i < nt; i++){
			pts[i] = new PopulateThread(fp, r, tm);
			dlts[i] = new DeleteThread(r, tm, dltwords[i]);
		}
	}

	/**
	 * starts all PopulateThreads, joins them
	 */
	public void startPopulateWorkers(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		//Create threads
		for(int i = 0; i < pts.length; i++){
			threads.add(new Thread(pts[i]));
			threads.get(i).start();
		}
		
		//Wait for threads to finish
		for(int i = 0; i < pts.length; i++){
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	/**
	 * starts all DeleteThreads, joins them
	 */
	public void startDeleteWorkers(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		//Create threads
		for(int i = 0; i < dlts.length; i++){
			threads.add(new Thread(dlts[i]));
			threads.get(i).start();
		}
		
		//Wait for threads to finish
		for(int i = 0; i < dlts.length; i++){
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
