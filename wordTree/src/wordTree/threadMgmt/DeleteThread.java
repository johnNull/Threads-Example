package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.trees.Node;

public class DeleteThread extends Thread {
	private FileProcessor in;
	private Results out;
	private Node head;
	private String word;
	
	public PopulateThread(FileProcessor f, Results r, Node n, String s) {
		in = f;
		out = r;
		head = n;
		word = s;
	}
	
	public void run() {
		head.delete(word);
	}
}