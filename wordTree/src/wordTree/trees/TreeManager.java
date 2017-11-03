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
			createHead(word);
		} else {
			head.populate(word);
		}
	}
	
	//Create head - Synchonized for safety
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