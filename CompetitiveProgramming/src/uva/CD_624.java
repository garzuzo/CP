package uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class CD_624 {

	static Cd answ;
	static boolean finished;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String c;
		while ((c = in.readLine()) != null) {
			answ = new Cd(0, new StringBuilder());
			String[] cAct = c.split(" ");
			int N = Integer.parseInt(cAct[0]);
			int nTracks = Integer.parseInt(cAct[1]);
			int arr[] = new int[nTracks];

			for (int i = 0; i < nTracks; i++) {
				arr[i] = Integer.parseInt(cAct[i + 2]);
			}
			finished = false;
			backtracking(arr, 0, N, 0, new LinkedList<Integer>());

			System.out.print(answ.vals.toString() + "sum:" + answ.sum + "\n");

		}
		out.close();

	}

	static void backtracking(int[] arr, int pointer, int N, int sum, LinkedList<Integer> act) {

		if (!finished) {
			for (int i = pointer; i < arr.length && !finished; i++) {
				if (sum + arr[i] <= N) {
					act.offer(arr[i]);
					// act.add(arr[i]);
					sum += arr[i];
					backtracking(arr, i + 1, N, sum, act);
					if (!finished) {
						StringBuilder sb = new StringBuilder();

						if (sum > answ.sum) {
							for (int j : act)
								sb.append(j + " ");

							Cd cdAct = new Cd(sum, sb);

							answ = cdAct;
						}
						if (N == sum) {
							finished = true;
						}
						sum -= arr[i];
						act.pollLast();

					}
				}

			}

		}

	}

	static class Cd {

		int sum;
		StringBuilder vals;

		Cd(int sum, StringBuilder vals) {
			this.sum = sum;
			this.vals = vals;
		}

	}
}
