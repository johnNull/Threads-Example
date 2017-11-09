package wordTree.trees;

//Note: Class will be updated appropriately, will add JavaDoc comments later
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;
import wordTree.store.Results;

public class Node {
	private String word;
	private int count;
	private Node left;
	private Node right;
	
	/**
	 * Constructor for Node in BST
	 */
	public Node(String w, Results r) {
		r.writeToScreen("Node created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		word = w;
		count = 1;
		left = null;
		right = null;
	}
	
	/**
	 * Populate Tree with new Nodes
	 * @param w String to compare and create new Node or add word count
	 * @param r Results instance to pass into new Node
	 */
	public void populate(String w, Results r) {
		//Get alphabetical ordering of words
		int comparison = w.compareTo(word);
		if (comparison == -1) {
			//Populate left
			if (left == null) {
				left = new Node(w, r);
			} else {
				left.populate(w, r);
			}
		} else if (comparison == 0) {
			//Add word count
			count++;
		} else {
			//Populate Right
			if (right == null) {
				right = new Node(w, r);
			} else {
				right.populate(w, r);
			}
		}
	}
	
	/**
	 * Search for Node with Word
	 * @param w String to find matching Node
	 * @return The matching node found in tree or null if not found
	 */
	public Node search(String w) {
		//Get alphabetical ordering of words
		int comparison = w.compareTo(word);
		if (comparison == -1) {
			//Get value of left
			if (left == null) {
				return null;
			} else {
				return left.search(w);
			}
		} else if (comparison == 0) {
			return this;
		} else {
			//Get value of right
			if (right == null) {
				return null;
			} else {
				return right.search(w);
			}
		}
	}
	
	/**
	 * Delete one word instance
	 * @param r Results instance for printing log messages.
	 */
	public synchronized void delete(Results r) {
		//Remove word count
		if (count > 0) {
			r.writeToScreen(word + " deleted\n", MyLogger.DebugLevel.WORD_REMOVED);
			count--;
		}
	}
	
	/**
	 * Get word count, character count, and distinct word count.
	 * @param counts Counts instance to store values
	 */
	public void getCounts(Counts counts) {
		//Add left counts
		if (left != null) {
			left.getCounts(counts);
		}
		
		//Add right counts
		if (right != null) {
			right.getCounts(counts);
		}
		
		//Determine value of count
		if (count > 0) {
			//Get character count
			int characterCount = count * word.length();
			
			//Add counts
			counts.addValues(count, characterCount, 1);
		}
	}
	

	/**
	 * Gets String version of subtree
	 * @return String representing subtree.
	 */
	public String toString() {
		String output = "";
		
		if (left != null) {
			output = output + left.toString();
		}
		
		output = output + word + " - " + count + "\n";
		
		if (right != null) {
			output = output + right.toString();
		}
		
		return output;
	}
}
