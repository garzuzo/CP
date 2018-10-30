package uva;

import java.util.*;
import java.io.*;

public class Dominos_11504 {
	static int V; // No. of vertices
	static LinkedList<Integer> adj[];
	static LinkedList<Integer> transp[];
	static int cont;
	static HashMap<Integer, Node> SCCGraph;
	static HashMap<Integer, Integer> nodeToStrong;

	static void DFSUtil(int v, boolean visited[], int act) {
		// Mark the current node as visited and print it
		visited[v] = true;
		// System.out.print(v + " ");
		SCCGraph.get(act).adj.add(v);
		nodeToStrong.put(v, act);
		int n;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = transp[v].iterator();
		while (i.hasNext()) {
			n = i.next();
			if (!visited[n])
				DFSUtil(n, visited, act);
		}
	}

	static void fillOrder(int v, boolean visited[], Stack stack) {
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

	static void printSCCs() {
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
		// Graph gr = getTranspose();

		// Mark all the vertices as not visited (For second DFS)
		for (int i = 0; i < V; i++)
			visited[i] = false;

		SCCGraph = new HashMap<Integer, Node>();
		nodeToStrong = new HashMap<Integer, Integer>();
		int cont = 0;
		// Now process all vertices in order defined by Stack

		while (stack.empty() == false) {
			// Pop a vertex from stack
			int v = (int) stack.pop();

			// Print Strongly connected component of the popped vertex
			if (visited[v] == false) {
				SCCGraph.put(cont, new Node(cont));
				DFSUtil(v, visited, cont);
				cont++;
				// System.out.println();
			}
		}

	}

	static void addEdge(int u, int v) {
		adj[u].add(v);
		// adj[v].add(u);
		transp[v].add(u);
		// transp[u].add(v);
	}

	static void fillList() {
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < V; i++) {
			transp[i] = new LinkedList<Integer>();
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			String[] act = in.readLine().split(" ");
			V = Integer.parseInt(act[0]);

			int c = Integer.parseInt(act[1]);

			adj = new LinkedList[V];
			transp = new LinkedList[V];
			fillList();
			for (int j = 0; j < c; j++) {
				String cAct[] = in.readLine().split(" ");
				int u = Integer.parseInt(cAct[0]) - 1;
				int v = Integer.parseInt(cAct[1]) - 1;
				addEdge(u, v);
				// addEdge(v, u);
			}
			printSCCs();
			int answ = verify();

			out.write(answ+"\n");
		}
		out.close();

	}

	static int verify() {

		int n = SCCGraph.size();
		ArrayList<Node> arr = new ArrayList<Node>();

		for (Node act : SCCGraph.values()) {

			arr.add(act);
			HashSet<Integer> hsAdj = act.adj;
			for (int actAdj : hsAdj) {
				LinkedList<Integer> lAdj = adj[actAdj];
				for (int valAdj : lAdj) {
					if (nodeToStrong.get(valAdj) != act.id) {
						act.nodeAdj.add(nodeToStrong.get(valAdj));
					}
				}

			}

		}

		for (int i = 0; i < arr.size(); i++) {

			Node act = arr.get(i);
			boolean[] visited = new boolean[n];
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add(act);
			int cont = 0;
			while (!queue.isEmpty()) {
				int val = queue.peek().id;
				if (!visited[val]) {
					HashSet<Integer> nAdj = queue.poll().nodeAdj;
					visited[val] = true;
					for (int a : nAdj) {

						if (!visited[a]) {
							queue.add(SCCGraph.get(a));
							act.adj.add(a);
						cont++;	
						}
					}
				} else
					queue.poll();
			}
			act.contAdj = cont;
		}
		Collections.sort(arr);
		
		
		
		boolean[] visited = new boolean[n];
		int answ=0;
		for (int i = arr.size() - 1; i >= 0; i--) {
			Node act=arr.get(i);
			if(!visited[act.id]) {
				answ++;
				visited[act.id]=true;
			
			for(int val:act.nodeAdj) {
				if(!visited[val])
				visited[val]=true;
			}
			}
		}
		
//		Queue<Node> queue = new ArrayDeque<Node>();
//		int answ = 0;
//		for (int i = arr.size() - 1; i >= 0; i--) {
//
//			if (!SCCGraph.get(arr.get(i).id).visited) {
//				queue.add(arr.get(i));
//				// visited[i] = true;
//				while (!queue.isEmpty()) {
//					int val = queue.peek().id;
//					if (!SCCGraph.get(val).visited) {
//						HashSet<Integer> hsAct = queue.poll().nodeAdj;
//						// visited[val] = true;
//						SCCGraph.get(val).visited = true;
//						for (int actAdj : hsAct) {
//
//							if (!SCCGraph.get(actAdj).visited) {
//								queue.add(SCCGraph.get(actAdj));
//							}
//
//						}
//					} else {
//						queue.poll();
//					}
//				}
//				answ++;
//			}
//		}

		return answ;
	}

	static class Node implements Comparable<Node> {

		int id;
		int contAdj;
		// SCC adj
		HashSet<Integer> nodeAdj;
		// adj normal nodes
		HashSet<Integer> adj;
		boolean visited;

		public Node(int id) {
			this.id = id;
			nodeAdj = new HashSet<Integer>();
			adj = new HashSet<Integer>();
			contAdj = 0;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return contAdj - o.contAdj;
		}
	}
}
