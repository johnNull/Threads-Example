package wordTree.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]
      DEBUG_VALUE=2 [Print to stdout everytime a line is read from the input file]
      DEBUG_VALUE=1 [Print to stdout everytime a word is deleted from the Tree]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, WORD_REMOVED, READ_LINE, IN_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;

	/**
	 * Take in an int and assign debugLevel accordingly.
	 * @param levelIn integer corresponding to DebugLevel
	 */
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  	case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  	case 3: debugLevel = DebugLevel.IN_RUN; break;
		case 2: debugLevel = DebugLevel.READ_LINE; break;
		case 1: debugLevel = DebugLevel.WORD_REMOVED; break;
	  	case 0: debugLevel = DebugLevel.RELEASE; break;
	}
    }
	/**
	 * Set debugLevel directly from enum.
	 * @param levelIn DebugLevel to log with
	 */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

 	/** 
	 * Write message if debugLevel is the same as input.
	 * @param message text to be printed to stdout
	 * @param levelIn specifies at what DebugLevel to print the message.
	 */
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
