package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.trees.Node;

public class PopulateThread extends Thread {
	private FileProcessor in;
	private Results out;
	private Node head;
	
	public PopulateThread(FileProcessor f, Results r, Node n) {
		in = f;
		out = r;
		head = n;
	}
	
	public void run() {
		String word = in.readWord();
		while (word != null) {
			head.populate(word);
			word = in.readWord();
		}
	}
}