package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.trees.TreeManager;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;
import wordTree.store.Results;

public class DeleteThread implements Runnable {
	private FileProcessor in;
	private Results out;
	private TreeManager tree;
	private String word;
	
	/**
	 * Constructor for DeleteThread
	 * @param r Results instance for printing
	 * @param tm TreeManager to set up binary search tree
	 * @param s String to delete
	 */
	public DeleteThread(Results r, TreeManager tm, String s) {
		r.writeToScreen("DeleteThread created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		out = r;
		tree = tm;
		word = s;
	}
	
	/**
	 * Thread method to delete one word instance from tree
	 */
	public void run() {
		out.writeToScreen("DeleteThread running\n", MyLogger.DebugLevel.IN_RUN);
		tree.delete(word, out);
	}
}
