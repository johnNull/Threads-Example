package wordTree.trees;

public class Counts {
	private int wordCount;
	private int characterCount;
	private int uniqueCount;

	public Counts() {
		wordCount = 0;
		characterCount = 0;
		uniqueCount = 0;
	}
	
	public void addValues(int wc, int cc, int uc) {
		wordCount += wc;
		if (wordCount < 0) {
			wordCount = 0;
		}
		characterCount += cc;
		if (characterCount < 0) {
			characterCount = 0;
		}
		uniqueCount += uc;
		if (uniqueCount < 0) {
			uniqueCount = 0;
		}
	}
	
	public int getWordCount() {
		return wordCount;
	}
	
	public int getCharacterCount() {
		return charcterCount;
	}
	
	public int getUniqueCount() {
		return uniqueCount;
	}
}