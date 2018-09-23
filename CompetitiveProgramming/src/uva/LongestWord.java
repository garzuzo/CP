package uva;

import java.io.*;
import java.util.*;

public class LongestWord {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String answ = null;
		boolean flag = true;
		while (flag) {
			String s = in.readLine();
			//System.out.println(s.matches("[a-zA-Z]"));
			String arr[] = s.replaceAll("[^-a-zA-Z]", " ").trim().split(" ");
			for (String as : arr) {
				if (as.equals("E-N-D"))
					flag = false;
				else if (answ == null || answ.length() < as.length())
					answ = as;

			}
		}
		System.out.println(answ.toLowerCase());
	}

}
