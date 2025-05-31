// Function to find DFS of Graph from given source s
import java.util.*;

class dfs {
    
    // DFS from given source s
    static ArrayList<Integer> dfs(
        ArrayList<ArrayList<Integer>> adj) {//yaha woo garph wala adjacency list para me liya gaya hai
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs_individual(adj, visited, i, res);
            }
        }
        return res;
    }
    
    public static void dfs_individual(ArrayList<ArrayList<Integer>> adj, boolean visited[], int curr, ArrayList<Integer> res) {
        res.add(curr);
        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neigh = adj.get(curr).get(i);
            if (!visited[neigh]) {
                dfs_individual(adj, visited, neigh, res);
            }
        }
    }

    public static void main(String[] args) {
        
        // create the adjacency list
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }
       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();//adjacency list bana raha haii jiske ander graph hai
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));       
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));       
        adj.add(new ArrayList<>(Arrays.asList(1,4)));          
        adj.add(new ArrayList<>(Arrays.asList(2,3)));          
        
        
        ArrayList<Integer> res = dfs(adj);
        for (int i =0;i<res.size();i++) {
            System.out.println(res.get(i));//res k ek ek element ko print kar raha hai
        }
    }
}