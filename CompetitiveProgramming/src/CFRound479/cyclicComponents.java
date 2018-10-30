package CFRound479;

import java.util.ArrayList;
import java.util.Scanner;

public class cyclicComponents {

	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static boolean cycle;
	static int nCiclos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lect = new Scanner(System.in);

		int n = lect.nextInt();
		int m = lect.nextInt();

		graph = new ArrayList[n];

		for (int i = 0; i < m; i++) {
			int v = lect.nextInt();
			int u = lect.nextInt();
			graph[v].add(u);
			graph[u].add(v);
		}
		dfs();

	}

	static void dfs() {

	}

	/**
	 * E. Cyclic Components
	 * 
	 * 
	 * An undirected graph consists of two sets: set of nodes (called vertices) and
	 * set of edges. Each edge connects a pair of vertices. All edges are
	 * bidirectional (i.e. if a vertex a is connected with a vertex b, a vertex b is
	 * also connected with a vertex a). An edge can't connect vertex with itself,
	 * there is at most one edge between a pair of vertices.
	 * 
	 * Two vertices u and v belong to the same connected component 
	 * if and only if there is at least one path along edges connecting u and v
	 */
	// static void dfs() {
	// for (int i = 1; i <= n; i++) {
	// if (!visited[i]) {
	// cycle = true;
	// dfs(i);
	// if (cycle)
	// nCiclos++;
	// }
	// }
	// }
	//
	// static void dfs(int s) {
	// visited[s] = true;
	// int counter = 0;
	// for (int next : graph[s]) {
	// counter++;
	// if (!visited[next]) {
	// dfs(next);
	// }
	// }
	// if (counter != 2)
	// cycle = false;
	// }

}
