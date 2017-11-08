package wordTree.trees;

import wordTree.store.Results;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

//Needs to be updated, needs JavaDoc

public class TreeManager {
	private Node head;

	//Constructor
	public TreeManager(Results r) {
		r.writeToScreen("TreeManager created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		head = null;
	}
	
	//Populate tree
	public void populate(String word, Results r) {
		if (head == null) {
			createHead(word, r);
		} else {
			head.populate(word, r);
		}
	}
	
	//Create head - Synchronized for safety
	private synchronized void createHead(String word, Results r) {
		if (head == null) {
			head = new Node(word, r);
		} else {
			head.populate(word, r);
		}
	}
	
	//Delete words
	public void delete(String word, Results r) {
		if (head != null) {
			//Search for word, and delete instance
			Node n = head.search(word);
			if (n != null) {
				n.delete(r);
			}
		}
	}
	
	//Get counts
	public void getCounts(Results r) {
		//Instantiate counts
		Counts counts = new Counts(r);
		
		//Get counts
		if (head != null) {
			head.getCounts(counts);
		}
		
		//Create output
		String output = "";
		output = output + "The total number of words: " + counts.getWordCount() + "\n";
		output = output + "The total number of characters: " + counts.getCharacterCount() + "\n";
		output = output + "The total number of distinct words: " + counts.getUniqueCount() + "\n";
		r.append(output);
	}
	
	public String toString() {
		String output = "Tree Values:\n";
		
		if (head == null) {
			output = output + "[Empty]\n";
		} else {
			output = output + head.toString();
		}
		
		return output;
	}
}