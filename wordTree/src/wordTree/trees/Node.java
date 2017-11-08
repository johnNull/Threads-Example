package wordTree.trees;

//Note: Class will be updated appropriately, will add JavaDoc comments later
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class Node {
	private String word;
	private int count;
	private Node left;
	private Node right;
	
	//Constructor
	public Node(String w, Results r) {
		r.writeToScreen("Node created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		word = w;
		count = 1;
		left = null;
		right = null;
	}
	
	//Populate Tree
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
	
	//Search for Node with Word
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
	
	//Delete Word
	public synchronized void delete(Results r) {
		//Remove word count
		if (count > 0) {
			r.writeToScreen(word + " deleted\n", MyLogger.DebugLevel.WORD_REMOVED);
			count--;
		}
	}
	
	//Get Counts
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
