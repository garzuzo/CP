package uva;

import java.io.*;
import java.util.*;

public class plates {

	static HashSet<String> hs;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {

			hs = new HashSet<String>();
			char[] arr = in.readLine().toCharArray();

			backtracking(arr, 0, new StringBuilder());
			System.out.println(hs.size());

		}

	}

	static void backtracking(char[] arr, int index, StringBuilder sb) {

		if (sb.length() == 3 ) {
if( hs.contains(sb.toString()))
	sb.deleteCharAt(2);
else {
			hs.add(sb.toString());
			sb.deleteCharAt(2);
}
		} else {

			for (int i = index; i < arr.length; i++) {
				sb.append(arr[i]);
				if (index + 1 < arr.length) {

					backtracking(arr, index + 1, sb);
					if(sb.length()>0)
						sb.deleteCharAt(sb.length()-1);
				}

			}

			if(sb.length()>0)
			sb.deleteCharAt(sb.length()-1);

		}

	}

}
