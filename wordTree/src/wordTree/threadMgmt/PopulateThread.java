package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.trees.TreeManager;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;
import wordTree.store.Results;

public class PopulateThread implements Runnable {
	private FileProcessor in;
	private Results out;
	private TreeManager tree;
	private String[] words;
	
	public PopulateThread(FileProcessor f, Results r, TreeManager tm) {
		r.writeToScreen("PopulateThread created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		in = f;
		out = r;
		tree = tm;
	}
	
	public void run() {
		out.writeToScreen("PopulateThread running\n", MyLogger.DebugLevel.IN_RUN);
		String line = in.readLine();
		while (line != null) {
			out.writeToScreen("Line: " + line, MyLogger.DebugLevel.READ_LINE);
			if (!line.equals("")) {
				words = line.split(" ");
				for(int i = 0; i < words.length; i++){
					//System.out.println(words[i]);
					tree.populate(words[i], out);
				}
			}
			line = in.readLine();
		}
	}
}
