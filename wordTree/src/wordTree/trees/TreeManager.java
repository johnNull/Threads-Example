package wordTree.trees;

import wordTree.store.Results;

//Needs to be updated, needs JavaDoc

public class TreeManager {
	private Node head;

	//Constructor
	public TreeManager() {
		head = null;
	}
	
	//Populate tree
	public void populate(String word) {
		if (head == null) {
			createHead(word);
		} else {
			head.populate(word);
		}
	}
	
	//Create head - Synchronized for safety
	private synchronized void createHead(String word) {
		if (head == null) {
			head = new Node(word);
		} else {
			head.populate(word);
		}
	}
	
	//Delete words
	public void delete(String word) {
		if (head != null) {
			//Search for word, and delete instance
			Node n = head.search(word);
			if (n != null) {
				n.delete();
			}
		}
	}
	
	//Get counts
	public void getCounts(Results r) {
		//Instantiate counts
		Counts counts = new Counts();
		
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