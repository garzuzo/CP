package BrazilSubregionalContest;

import java.io.*;
import java.util.*;

public class PoliceHypothesis {

	static node[] hm;
	static boolean visited[];
	static int n;
	static HashMap<String, Integer> ocurrences;
	static Queue<node> queue;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String nq[] = in.readLine().split(" ");

		n = Integer.parseInt(nq[0]);
		int q = Integer.parseInt(nq[1]);

		String p = new String(in.readLine());

		String vals = in.readLine();

		hm = new node[n];
		ocurrences = new HashMap();
		// HashSet<Integer> root = new HashSet<Integer>();
		for (int i = 0; i < vals.length(); i++) {

			char act = vals.charAt(i);
			node nAct = new node(i, act);
			hm[i] = nAct;
			// root.add(i);
		}

		for (int i = 0; i < n - 1; i++) {

			String cAct[] = in.readLine().split(" ");

			int u = Integer.parseInt(cAct[0]) - 1;
			int v = Integer.parseInt(cAct[1]) - 1;
			// root.remove(v);
			hm[v].root = false;
			if (hm[u].left == null) {
				hm[u].left = hm[v];

				hm[v].parent = hm[u];
			} else {
				hm[u].right = hm[v];

				hm[v].parent = hm[u];
			}
		}

		int root = 0;
		for (int i = 0; i < hm.length; i++) {
			if (hm[i].root)
				root = i;
		}
		hierarchy(root);

		for (int i = 0; i < q; i++) {

			String qAct[] = in.readLine().split(" ");

			int instr = Integer.parseInt(qAct[0]);

			if (instr == 1) {

				int u = Integer.parseInt(qAct[1]) - 1;
				int v = Integer.parseInt(qAct[2]) - 1;

				String text = makeText(u, v);

				if (ocurrences.containsKey(text)) {
					out.write(ocurrences.get(text) + "\n");
				} else {
					int answ = search(text, p);
					// int answ = KMPSearch(p, text);
					ocurrences.put(text, answ);

					out.write(answ + "\n");
				}
			} else {
				int u = Integer.parseInt(qAct[1]) - 1;
				char x = qAct[2].charAt(0);

				hm[u].val = x;
			}

		}
		out.close();
	}

	static String makeText(int u, int v) {

		if (u == v)
			return hm[u].val + "";

		node max;
		node min;
		boolean uv = true;
		if (hm[u].pre.size() < hm[v].pre.size()) {
			min = hm[u];
			max = hm[v];
		} else {
			uv = false;
			max = hm[u];
			min = hm[v];
		}
		StringBuilder maxToLCA = new StringBuilder();
		StringBuilder minToLCA = new StringBuilder();

		// reverse cadena2
		// recorrere max primero

		// max != null &&
		while (!min.pre.contains(max.pos) && min.pos != max.pos) {

			maxToLCA.append(max.val);
			max = max.parent;

		}
		if (max != null)
			maxToLCA.append(max.val);

		// otro ciclo
		while (max != null && min != null && min.pos != max.pos) {
			minToLCA.append(min.val);

			min = min.parent;
		}
		String answ;
		if (uv) {
			answ = minToLCA.append(maxToLCA.reverse().toString()).toString();
		} else {
			answ = maxToLCA.append(minToLCA.reverse().toString()).toString();
		}
		return answ;

	}

	static int search(String text, String pattern) {
		String concat = pattern + "$" + text;

		int l = concat.length();
		int Z[] = new int[l];
		int cont = 0;
		getZarr(concat, Z);

		for (int i = 0; i < l; ++i) {

			if (Z[i] == pattern.length())
				cont++;
		}

		return cont;
	}

	static void getZarr(String str, int[] Z) {

		int n = str.length();
		int L = 0, R = 0;

		for (int i = 1; i < n; ++i) {

			if (i > R) {
				L = R = i;

				while (R < n && str.charAt(R - L) == str.charAt(R))

					R++;

				Z[i] = R - L;
				R--;

			} else {

				int k = i - L;

				if (Z[k] < R - i + 1)

					Z[i] = Z[k];
				else {

					L = i;
					while (R < n && str.charAt(R - L) == str.charAt(R))

						R++;
					Z[i] = R - L;
					R--;

				}
			}

		}

	}

	static void hierarchy(int u) {

		queue = new ArrayDeque<node>();
		stack = new Stack<Integer>();

		queue.add(hm[u]);

		visited = new boolean[n];
		while (!queue.isEmpty()) {

			node act = queue.poll();

			stack.push(act.pos);
			visited[act.pos] = true;

			node actLeft = act.left;
			node actRight = act.right;
			if (actLeft != null)
				if (!visited[actLeft.pos]) {
					act.suc.add(actLeft.pos);
					actLeft.pre.add(act.pos);
					queue.add(actLeft);

					// if (act.parent != null)
					for (int posPre : act.pre) {
						actLeft.pre.add(posPre);
					}
					if (actRight != null)
						if (!visited[actRight.pos]) {
							// parent sucessor=son
							act.suc.add(actRight.pos);
							// act right predecessor=parent
							actRight.pre.add(act.pos);
							queue.add(actRight);

							// if (act.parent != null)
							for (int posPre : act.pre) {
								actRight.pre.add(posPre);
							}
						}

				}
		}
		while (!stack.isEmpty()) {

			node act = hm[stack.pop()];
			if (act.pos != u)
				for (int posAct : act.suc)
					act.parent.suc.add(posAct);

		}

	}

	static class node {

		int pos;
		char val;

		HashSet<Integer> suc;
		HashSet<Integer> pre;

		node left;
		node right;
		node parent;
		boolean root;
		// LinkedList<node> adj;

		node(int pos, char val) {
			this.pos = pos;
			this.val = val;
			// adj = new LinkedList<node>();
			suc = new HashSet<Integer>();
			pre = new HashSet<Integer>();
			root=true;
		}

	}
}
