package wordTree.trees;

import wordTree.store.Results;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class Counts {
	private int wordCount;
	private int characterCount;
	private int uniqueCount;

	public Counts(Results r) {
		r.writeToScreen("Counts created\n", MyLogger.DebugLevel.CONSTRUCTOR);
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
		return characterCount;
	}
	
	public int getUniqueCount() {
		return uniqueCount;
	}
}
