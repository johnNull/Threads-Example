package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.trees.TreeManager;

public class DeleteThread implements Runnable {
	private FileProcessor in;
	private Results out;
	private TreeManager tree;
	private String word;
	
	public DeleteThread(FileProcessor f, Results r, TreeManager tm, String s) {
		in = f;
		out = r;
		tree = tm;
		word = s;
	}
	
	public void run() {
		tree.delete(word);
	}
}
