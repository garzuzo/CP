package uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class CD_624 {

	static TreeSet<Cd> answ;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner in = new Scanner((System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String c;
		while (in.hasNext()) {
			answ = new TreeSet<Cd>();
			int N = in.nextInt();
			int nTracks = in.nextInt();
			int arr[] = new int[nTracks];

			for (int i = 0; i < nTracks; i++) {
				arr[i] = in.nextInt();
			}

			backtracking(arr, 0, N, 0, new ArrayList<Integer>());

			System.out.println(answ.first().vals.toString() + "sum:" + answ.first().sum);

		}

	}

	static void backtracking(int[] arr, int pointer, int N, int sum, ArrayList<Integer> act) {

		for (int i = pointer; i < arr.length; i++) {
			if (sum + arr[i] <= N) {
				act.add(arr[i]);
				sum += arr[i];
				backtracking(arr, i + 1, N, sum, act);

				StringBuilder sb = new StringBuilder();

				for (int j = 0; j < act.size(); j++) {
					sb.append(act.get(j) + " ");
				}

				Cd cdAct = new Cd(sum, sb);
				answ.add(cdAct);

				sum -= arr[pointer];
				act.remove(act.size() - 1);

			}

		}

	}

	static class Cd implements Comparable<Cd> {

		int sum;
		StringBuilder vals;

		Cd(int sum, StringBuilder vals) {
			this.sum = sum;
			this.vals = vals;
		}

		@Override
		public int compareTo(Cd cd1) {
			// TODO Auto-generated method stub
			return sum > cd1.sum ? -1 : sum < cd1.sum ? 1 : cd1.vals.toString().toCharArray().length-(vals.toString().toCharArray().length);
		}

	}
}
