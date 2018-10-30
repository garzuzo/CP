package uva;

import java.io.*;
import java.util.*;

public class InternetBandwidth_820 {

	static int V;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int n;
		int cont = 1;
		while (true) {
			n = Integer.parseInt(in.readLine());

			if (n == 0)
				break;

			int[][] matrix = new int[n][n];
			String[] act = in.readLine().split(" ");

			int s = Integer.parseInt(act[0]) - 1;
			int t = Integer.parseInt(act[1]) - 1;
			int c = Integer.parseInt(act[2]);
			V = n;
			for (int i = 0; i < c; i++) {

				act = in.readLine().split(" ");
				int u = Integer.parseInt(act[0]) - 1;
				int v = Integer.parseInt(act[1]) - 1;
				int bw = Integer.parseInt(act[2]);

				matrix[u][v] += bw;
				matrix[v][u] += bw;

			}
			int answ = fordFulkerson(matrix, s, t);
			out.write("Network " + cont + "\nThe bandwidth is " + answ + ".\n");
			out.write("\n");
			cont++;
		}
		out.close();

	}

	static boolean bfs(int rGraph[][], int s, int t, int parent[]) {
		// Create a visited array and mark all vertices as not
		// visited
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			visited[i] = false;

		// Create a queue, enqueue source vertex and mark
		// source vertex as visited
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1;

		// Standard BFS Loop
		while (queue.size() != 0) {
			int u = queue.poll();

			for (int v = 0; v < V; v++) {
				if (visited[v] == false && rGraph[u][v] > 0) {
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		// If we reached sink in BFS starting from source, then
		// return true, else false
		return (visited[t] == true);
	}

	// Returns tne maximum flow from s to t in the given graph
	static int fordFulkerson(int graph[][], int s, int t) {
		int u, v;

		// Create a residual graph and fill the residual graph
		// with given capacities in the original graph as
		// residual capacities in residual graph

		// Residual graph where rGraph[i][j] indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is
		// not)
		int rGraph[][] = new int[V][V];

		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];

		// This array is filled by BFS and to store path
		int parent[] = new int[V];

		int max_flow = 0; // There is no flow initially

		// Augment the flow while tere is path from source
		// to sink
		while (bfs(rGraph, s, t, parent)) {
			// Find minimum residual capacity of the edhes
			// along the path filled by BFS. Or we can say
			// find the maximum flow through the path found.
			int path_flow = 100000000;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}

			// update residual capacities of the edges and
			// reverse edges along the path
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}

			// Add path flow to overall flow
			max_flow += path_flow;
		}

		// Return the overall flow
		return max_flow;
	}

}
