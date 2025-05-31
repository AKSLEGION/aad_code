import java.util.*;

class prim {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public void createEdge(ArrayList<Edge> graph[]) {
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        graph[0].add(new Edge(0, 2, 11));
        graph[2].add(new Edge(2, 0, 12));

        graph[1].add(new Edge(1, 3, 12));
        graph[3].add(new Edge(3, 1, 12));

        graph[2].add(new Edge(2, 4, 13));
        graph[4].add(new Edge(4, 2, 13));

        graph[3].add(new Edge(3, 5, 14));
        graph[5].add(new Edge(5, 3, 14));

        graph[4].add(new Edge(4, 5, 15));
        graph[5].add(new Edge(5, 4, 15));

        graph[5].add(new Edge(5, 6, 16));
        graph[6].add(new Edge(6, 5, 16));

        graph[3].add(new Edge(3, 4, 17));
        graph[4].add(new Edge(4, 3, 17));

    }

    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parA] = parB;
            rank[parB]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void krushKalAlgo(ArrayList<Edge> edges, int v) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;
        for (int i = 0; count < v - 1; i++) {
            Edge e = edges.get(i);
            int src = e.src;
            int dest = e.dest;
            int parA = find(src);
            int parB = find(dest);
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        GraphTest gt = new GraphTest();
        gt.createEdge(graph);

        ArrayList<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                if (e.src < e.dest) {
                    allEdges.add(e);
                }
            }
        }

        System.out.print("Kruskal's MST Cost: ");
        krushKalAlgo(allEdges, v);
        
    }
}
