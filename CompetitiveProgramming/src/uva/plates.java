package uva;

import java.io.*;
import java.util.*;

public class plates {

	static HashSet<String> hs;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {

			hs = new HashSet<String>();
			char[] arr = in.readLine().toCharArray();

			backtracking(arr, 0, new StringBuilder());
			out.write(hs.size()+"\n");

		}
		out.close();

	}

	static void backtracking(char[] arr, int index, StringBuilder sb) {

		if (sb.length() == 3) {
			if (hs.contains(sb.toString()))
				sb.deleteCharAt(2);

			else {
				hs.add(sb.toString());
				sb.deleteCharAt(2);
			}
		} else if (sb.length() < 3 && index >= arr.length)
			sb.deleteCharAt(sb.length()-1);
		else if (index < arr.length) {

			for (int i = index; i < arr.length; i++) {
				sb.append(arr[i]);

				backtracking(arr, i + 1, sb);
				// if (sb.length() > 0)
				// sb.deleteCharAt(sb.length() - 1);

			}

			if (sb.length() > 0)
				sb.deleteCharAt(sb.length() - 1);

		}

	}

}
