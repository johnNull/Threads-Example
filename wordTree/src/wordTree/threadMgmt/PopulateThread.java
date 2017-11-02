package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.trees.TreeManager;

public class PopulateThread implements Runnable {
	private FileProcessor in;
	private Results out;
	private TreeManager tree;
	private String[] words;
	
	public PopulateThread(FileProcessor f, Results r, TreeManager tm) {
		in = f;
		out = r;
		tree = tm;
	}
	
	public void run() {
		String line = in.readLine();
		while (line != null) {
			words = line.split(" ");
			for(int i = 0; i < words.length; i++){
				//System.out.println(words[i]);
				tree.populate(words[i]);
			}
			line = in.readLine();
		}
	}
}
