import java.util.*;

class prim {

    public static int primsAlgo(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int V = adj.size();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(2)));

        boolean[] visited = new boolean[V];

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(-1);
        temp.add(0);
        temp.add(0);
        pq.offer(start); // first hum 0 waale node ko add kar rahe hain weight 0 de ke

        int finalCost = 0;

        while (!pq.isEmpty()) {
            ArrayList<Integer> curr = pq.poll();
            int node = curr.get(1);

            if (!visited[node]) { // priority queue se pehla edge nikal rahe and agar destination node vi
                visited[node] = true;
                finalCost += curr.get(2);

                for (int i = 0; i < adj.get(node).size(); i++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(adj.get(node).get(i).get(0));
                    temp.add(adj.get(node).get(i).get(1));
                    pq.offer(temp);
                }
            }
        }
        System.out.println(finalCost);
        return finalCost;
    }


    public static void main(String[] args) {
       
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();//adjacency list bana raha haii jiske ander graph hai
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(1);
        edge1.add(4);
        adj.get(0).add(edge1);
        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(2);
        edge2.add(9);
        adj.get(0).add(edge2);


        ArrayList<Integer> edge3 = new ArrayList<>();
        edge3.add(0);
        edge3.add(4);
        adj.get(1).add(edge3);
        ArrayList<Integer> edge4 = new ArrayList<>();
        edge4.add(2);
        edge4.add(1);
        adj.get(1).add(edge4);
        ArrayList<Integer> edge5 = new ArrayList<>();
        edge5.add(3);
        edge5.add(10);
        adj.get(1).add(edge5);


        ArrayList<Integer> edge6 = new ArrayList<>();
        edge6.add(0);
        edge6.add(9);
        adj.get(2).add(edge6);
        ArrayList<Integer> edge7 = new ArrayList<>();
        edge7.add(4);
        edge7.add(2);
        adj.get(2).add(edge7);

        ArrayList<Integer> edge8 = new ArrayList<>();
        edge8.add(1);
        edge8.add(10);
        adj.get(3).add(edge8);
        ArrayList<Integer> edge9 = new ArrayList<>();
        edge9.add(4);
        edge9.add(3);
        adj.get(3).add(edge9);

        ArrayList<Integer> edge10 = new ArrayList<>();
        edge10.add(2);
        edge10.add(2);
        adj.get(4).add(edge10);
        ArrayList<Integer> edge11 = new ArrayList<>();
        edge11.add(3);
        edge11.add(3);   
        adj.get(4).add(edge11);   

        for(int i=0;i<V;i++){
            System.out.println(adj.get(i));
        }
        
        int finalCost = primsAlgo(adj);
        System.out.println(finalCost);
    }
}
