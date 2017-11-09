package wordTree.trees;

import wordTree.store.Results;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class Counts {
	private int wordCount;
	private int characterCount;
	private int uniqueCount;

	/**
	 * Constructor for Counts
	 * @param r Results instance to print log messages
	 */
	public Counts(Results r) {
		r.writeToScreen("Counts created\n", MyLogger.DebugLevel.CONSTRUCTOR);
		wordCount = 0;
		characterCount = 0;
		uniqueCount = 0;
	}
	
	/**
	 * Sums up word count, unique word count, and character count
	 * @param wc word count
	 * @param cc character count
	 * @param unique word count
	 */
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
	
	/**
	 * Gets the word count
	 * @return word count
	 */
	public int getWordCount() {
		return wordCount;
	}
	
	/**
	 * Gets the character count
	 * @return character count
	 */
	public int getCharacterCount() {
		return characterCount;
	}
	
	/**
	 * Gets the unique word count
	 * @return unique word count
	 */
	public int getUniqueCount() {
		return uniqueCount;
	}
}
