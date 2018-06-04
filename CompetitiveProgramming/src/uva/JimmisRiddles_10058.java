package uva;

import java.io.*;
import java.util.*;

public class JimmisRiddles_10058 {

	static final String ARTICLE = "(a|the)";
	static final String NOUN = "(tom|jerry|goofy|mickey|jimmy|dog|cat|mouse)";
	static final String ACTOR = "("+NOUN + "|" + ARTICLE +" "+ NOUN+")";
	static final String ACTIVE_LIST ="(" + ACTOR + " and )*" + ACTOR;
	static final String VERB = "(hate|love|know|like)s*";
	static final String ACTION = ACTIVE_LIST +" "+VERB +" "+ ACTIVE_LIST;
	static final String STATEMENT = ACTION  + "( , " + ACTION + ")*";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
while(in.hasNext()) {
		String act = in.nextLine().replaceAll(" +"," ");

		boolean answ = act.matches(STATEMENT);
System.out.println(answ?"YES I WILL":"NO I WON'T");

}
	}

}
