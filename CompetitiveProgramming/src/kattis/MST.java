package kattis;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class MST {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter esc = new BufferedWriter(new OutputStreamWriter(System.out));

        String casoAct = lect.readLine();
        while (!casoAct.equals("0 0")) {

            String[] arrAct = casoAct.split(" ");
            int n = Integer.parseInt(arrAct[0]);
            int m = Integer.parseInt(arrAct[1]);

            ArrayList<edge> listEdges = new ArrayList<edge>();
            for (int i = 0; i < m; i++) {

                // u v w
                String[] trio = lect.readLine().split(" ");
                int u = Integer.parseInt(trio[0]);
                int v = Integer.parseInt(trio[1]);
                int w = Integer.parseInt(trio[2]);
                edge edAct;
                if(u<v)
                    edAct = new edge(u, v, w);
                // edge edAct1 = new edge(v, u, w);
                else
                     edAct = new edge(v, u, w);
                listEdges.add(edAct);
                // listEdges.add(edAct1);

            }
            
            ArrayList<edge> retorno = new ArrayList<edge>();
            int resultado = kruskal(n, listEdges, retorno);
            if (resultado != 0 && n-1==retorno.size()) {
                esc.write(resultado + "\n");
                
                Collections.sort(retorno, edge.comp);
                for (int i = 0; i < retorno.size(); i++) {
                    edge act = retorno.get(i);
                        esc.write(act.u + " " + act.v + "\n");
                }
            } else
                esc.write("Impossible\n");

            casoAct = lect.readLine();
        }
        esc.flush();
    }

    static int kruskal(int N, ArrayList<edge> edges, ArrayList<edge> retorno) {

        UnionFind uf = new UnionFind(N);

        Collections.sort(edges);
        int mstCost = 0;

        for (edge ed : edges) {

            if (!uf.isSameSet(ed.u, ed.v)) {
                mstCost += ed.weight;
                uf.unionSet(ed.u, ed.v);
                retorno.add(ed);
            }

        }
        
            return mstCost;
    }
}

class edge implements Comparable<edge> {

    int weight;
    int u;
    int v;

    public edge(int u, int v, int weight) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }

    @Override
    public int compareTo(edge e1) {
        // TODO Auto-generated method stub
        return weight - e1.weight;
    }

    public static Comparator<edge> comp = new Comparator<edge>() {

        @Override
        public int compare(edge o1, edge o2) {
            // TODO Auto-generated method stub
            return o1.u!=o2.u?o1.u-o2.u:o1.v-o2.v;
        }
    };

}

class UnionFind { // OOP style
    private Vector<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new Vector<Integer>(N);
        rank = new Vector<Integer>(N);
        setSize = new Vector<Integer>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i)
            return i;
        else {
            int ret = findSet(p.get(i));
            p.set(i, ret);
            return ret;
        }
    }

    public Boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank.get(x) > rank.get(y)) {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y);
                setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y))
                    rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    public int sizeOfSet(int i) {
        return setSize.get(findSet(i));
    }
}