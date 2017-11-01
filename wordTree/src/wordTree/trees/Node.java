package wordTree.trees;

//Note: Class will be updated appropriately, will add JavaDoc comments later

public class Node {
	private String word;
	private int count;
	private Node left;
	private Node right;
	
	//Constructor
	public Node(String w) {
		word = w;
		count = 1;
		left = null;
		right = null;
	}
	
	//Populate Tree
	public void populate(String w) {
		//Get alphabetical ordering of words
		int comparison = w.compareTo(word);
		if (comparison == -1) {
			//Populate left
			if (left == null) {
				left = new Node(w);
			} else {
				left.populate(w);
			}
		} else if (comparison == 0) {
			//Add word count
			count++;
		} else {
			//Populate Right
			if (right == null) {
				right = new Node(w);
			} else {
				right.populate(w);
			}
		}
	}
	
	//Delete Word
	public void delete(String w) {
		//Get alphabetical ordering of words
		int comparison = w.compareTo(word);
		if (comparison == -1) {
			//Delete left
			left.populate(w);
		} else if (comparison == 0) {
			//Remove word count
			if (count > 0) {
				count--;
			}
		} else {
			//Delete right
			right.populate(w);
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
			int charcterCount = count * word.length();
			
			//Add counts
			counts.addValues(count, characterCount, 1);
		}
	}
}