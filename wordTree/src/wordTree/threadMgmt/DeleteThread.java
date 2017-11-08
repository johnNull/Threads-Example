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
	
	public DeleteThread(FileProcessor f, Results r, TreeManager tm, String s) {
		r.writeToScreen("DeleteThread created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		in = f;
		out = r;
		tree = tm;
		word = s;
	}
	
	public void run() {
		out.writeToScreen("DeleteThread running\n", MyLogger.DebugLevel.IN_RUN);
		tree.delete(word, out);
	}
}
