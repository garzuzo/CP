package uva;

//Java implementation of Kosaraju's algorithm to print all SCCs 
import java.io.*;
import java.util.*;
import java.util.LinkedList;

//This class represents a directed graph using adjacency list 
//representation 
class Graph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	// A recursive function to print DFS starting from v
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		//System.out.print(v + " ");

		int n;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	// Function that returns reverse (or transpose) of this graph
	Graph getTranspose() {
		Graph g = new Graph(V);
		for (int v = 0; v < V; v++) {
			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext())
				g.adj[i.next()].add(v);
		}
		return g;
	}

	void fillOrder(int v, boolean visited[], Stack stack) {
		// Mark the current node as visited and print it
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				fillOrder(n, visited, stack);
		}

		// All vertices reachable from v are processed by now,
		// push v to Stack
		stack.push(new Integer(v));
	}

	// The main function that finds and prints all strongly
	// connected components
	int printSCCs() {
		Stack stack = new Stack();

		// Mark all the vertices as not visited (For first DFS)
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Fill vertices in stack according to their finishing
		// times
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				fillOrder(i, visited, stack);

		// Create a reversed graph
		Graph gr = getTranspose();

		// Mark all the vertices as not visited (For second DFS)
		for (int i = 0; i < V; i++)
			visited[i] = false;

		int cont=0;
		// Now process all vertices in order defined by Stack
		while (stack.empty() == false) {
			// Pop a vertex from stack
			int v = (int) stack.pop();

			// Print Strongly connected component of the popped vertex
			if (visited[v] == false) {
				gr.DFSUtil(v, visited);
				cont++;
				//System.out.println();
			}
		}
		return cont;
	}

	// Driver method
	public static void main(String args[]) throws Exception{
		// Create a graph given in the above diagram
	
		
		//g.addEdge(3, 4);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			String[] act = in.readLine().split(" ");
		int 	V = Integer.parseInt(act[0]);
		Graph g = new Graph(V);
			int c = Integer.parseInt(act[1]);

			
			for (int j = 0; j < c; j++) {
				String cAct[] = in.readLine().split(" ");
				int u = Integer.parseInt(cAct[0]) - 1;
				int v = Integer.parseInt(cAct[1]) - 1;
				g.addEdge(u, v);
				// addEdge(v, u);
			}
		//System.out.println("Following are strongly connected components " + "in given graph ");
		int answ=g.printSCCs();
		System.out.println(answ);
	}
}
}