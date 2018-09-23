package codeforcesBasedOnTechnocup2019;

import java.io.*;
import java.util.*;

public class VasyaAndGoldTicket {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(in.readLine());
		String s = in.readLine();
		int[] set = new int[n];
		int mayor = -1;
		for (int i = 0; i < set.length; i++) {
			set[i] = Integer.parseInt(s.charAt(i) + "");
			if (set[i] > mayor)
				mayor = set[i];

		}

		int i = 0;
		int sumAct = 0;
		boolean flag = true;
		while (i < n && flag) {

			int act = set[i];
			if (act == mayor && sumAct == 0)
				i++;
			else if (sumAct + act < mayor) {
				sumAct += act;
				i++;
			} else if (sumAct+ act == mayor) {
				i++;
				sumAct = 0;
			} else if (sumAct != mayor)
				flag = false;

		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");

		// boolean answ = isSubsetSum(set, n, 10);

	}

//	static boolean isSubsetSum(int set[], int n, int sum) {
//
//		boolean subset[][] = new boolean[sum + 1][n + 1];
//
//		for (int i = 0; i <= n; i++) {
//			subset[0][i] = true;
//		}
//		for (int i = 0; i <= n; i++) {
//			subset[i][0] = true;
//		}
//
//		for (int i = 0; i <= sum; i++) {
//			for (int j = 0; j <= n; j++) {
//				subset[i][j] = subset[i][j - 1];
//				if (i >= set[j - 1])
//					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
//
//			}
//
//		}
//		return subset[sum][n];
//	}

}
