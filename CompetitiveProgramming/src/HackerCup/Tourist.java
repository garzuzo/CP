package HackerCup;

import java.io.*;
import java.util.*;

public class Tourist {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(in.readLine());

		for (int i = 1; i <= t; i++) {

			Queue<attraction> queue = new ArrayDeque<attraction>();

			String nkv[] = in.readLine().split(" ");
			int n = Integer.parseInt(nkv[0]);
			int k = Integer.parseInt(nkv[1]);
			long v = Long.parseLong(nkv[2]);

			for (int j = 0; j < n; j++) {
				attraction a = new attraction(in.readLine(), j);
				queue.add(a);
			}
			int mod = (int) (v <= n ? v : (int) (v % (n)));
			if (mod == 0)
				mod = n;
			for (int j = 1; j < mod; j++) {

				for (int h = 0; h < k; h++) {

					queue.add(queue.remove());
				}
			}

			StringBuilder out = new StringBuilder();
			attraction[] answ = new attraction[k];
			int j = 0;
			for (attraction act : queue) {

				answ[j] = act;
				j++;
				if (j ==k)
					break;
			}
			Arrays.sort(answ);
			for (int j2 = 0; j2 < answ.length; j2++) {
				out.append(answ[j2].name);
				if (j2 + 1 != answ.length)
					out.append(" ");
			}
			System.out.println("Case #" + i + ": " + out.toString());
		}

	}

	static class attraction implements Comparable<attraction> {

		String name;
		int pos;

		public attraction(String name, int pos) {
			this.name = name;
			this.pos = pos;
		}

		@Override
		public int compareTo(attraction o) {
			// TODO Auto-generated method stub
			return pos - o.pos;
		}

	}

}
