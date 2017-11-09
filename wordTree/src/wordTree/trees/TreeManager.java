package wordTree.trees;

import wordTree.store.Results;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

//Needs to be updated, needs JavaDoc

public class TreeManager {
	private Node head;

	/**
	 * Constructor for TreeManager
	 * @param r Results instance for printing
	 */
	public TreeManager(Results r) {
		r.writeToScreen("TreeManager created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		head = null;
	}
	
	/**
	 * Populate the tree with a Node
	 * @param word String for which to create Node or add count to
	 * @param r Results instance to print
	 */
	public synchronized void populate(String word, Results r) {
		if (head == null) {
			createHead(word, r);
		} else {
			head.populate(word, r);
		}
	}
	
	/**
	 * Creates head of tree - synchronized for safety
	 * @param word String to create head Node with
	 * @param r Results instance to print
	 */
	private synchronized void createHead(String word, Results r) {
		if (head == null) {
			head = new Node(word, r);
		} else {
			head.populate(word, r);
		}
	}
	
	/**
	 * Delete a count of a word
	 * @param word String value to find node to delete from
	 * @param r Results instance to print
	 */
	public void delete(String word, Results r) {
		if (head != null) {
			//Search for word, and delete instance
			Node n = head.search(word);
			if (n != null) {
				n.delete(r);
			}
		}
	}
	
	/**
	 * Appends word count, character count, and unique word count to Results
	 * @param r Results instance to be appended to
	 */
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
	
	/**
	 * Gets String representation of the tree
	 * @return String representation of the tree 
	 */
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
