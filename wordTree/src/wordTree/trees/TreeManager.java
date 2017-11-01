package wordTree.trees;

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
			head = new Node(word);
		} else {
			head.populate(word);
		}
	}
	
	//Delete words
	public void delete(String word) {
		if (head != null) {
			head.delete(word);
		}
	}
	
	//Get counts
	public Counts getCounts() {
		//Instantiate counts
		Counts counts = new Counts();
		
		//Get counts
		if (head != null) {
			head.getCounts(counts);
		}
		
		return counts;
	}
}