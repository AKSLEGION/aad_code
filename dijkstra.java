import java.util.*;

class dijkstra {

    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {

        int V = adj.size();

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        // priority queue bana rahe jo a.get(1) ke order mein rahega , a.get(1) yahan hai distance, a.get(0) hoga node ka number

        ArrayList<Integer> dist = new ArrayList<>();
        for(int i=0;i<V;i++){
            dist.add(Integer.MAX_VALUE);
        } // distance array bana diye jisme saare distance abhi infinity hai

        // source distance kar diye
        dist.set(src,0);

        ArrayList<Integer> temp = new ArrayList<>(); // first node ko priority queue mein daal rahe
        temp.add(src);
        temp.add(0);
        pq.offer(start);

        // Loop until the priority queue is empty
        while (!pq.isEmpty()) {
            
            // Get the node with the minimum distance
            ArrayList<Integer> curr = pq.poll();
            int u = curr.get(0);
            int d = curr.get(1);

            // Traverse all adjacent vertices of the current node
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0);
                int weight = neighbor.get(1);

                // If there is a shorter path to v through u
                if (dist.get(v) > dist.get(u) + weight) {
                    // Update distance of v
                    dist.set(v , dist.get(u) + weight);

                    // Add updated pair to the priority queue
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(v);
                    temp.add(dist.get(v));
                    pq.offer(temp);
                }
            }
        }

        // Return the shortest distance array
        return dist;
    }

    public static void main(String[] args) {
        
        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
       
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();//adjacency list bana raha haii jiske ander graph hai
        for(int i=0;i<5;i++){
            adj.add(new ArrayList<>());
        }

        // yahan pe hum har edge ke liye 2 values likh rahe , ek ki destination node kya hai , doosra ki edge ka weight kya hai
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(1);
        edge1.add(4);
        adj.get(0).add(edge1); // yahan iska matlab 0 to 1 ek edge hai uska weight 4 hai
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
        
        int src = 0;
        ArrayList<Integer> dist = dijkstra(adj,src);
        for (int i =0;i<dist.size();i++) {
            System.out.println(dist.get(i));//res k ek ek element ko print kar raha hai
        }

    }
}
