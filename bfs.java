// Function to find BFS of Graph from given source s
import java.util.*;

class bfs {

    // BFS from given source s
    static ArrayList<Integer> bfs(
        ArrayList<ArrayList<Integer>> adj) {//yaha woo garph wala adjacency list para me liya gaya hai
        int V = adj.size();
        
    
        
        ArrayList<Integer> res = new ArrayList<>();//res me jis order me hum queue me daal rahe hai nodes wooo store honge  (visited wale nodes hai)
        
        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();
        
        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[V];//boolean aaray hai
        for(int s=0;s<V;s++)if(!visited[s]){
            visited[s] = true;
            q.add(s);
            
            while (!q.isEmpty()) {
                
                
                int curr = q.poll();//curr me woo node ka value store ho raha haii and woo node nikala ja raha hai
                res.add(curr);
                
                
                for (int x : adj.get(curr)) {//isse jo node niklaa usske adjacent wale nodess koliye
                    if (!visited[x]) {
                        visited[x] = true;//agar visited hai matlb woo used ho gaya thaa agar nhi then mark as visited karenge then queue me daalenge
                        q.add(x);
                    }
                }
            }
        }
       
        return res;//res me hamaraa order wisee haii
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
        
        
        ArrayList<Integer> res = bfs(adj);
        for (int i =0;i<res.length;i++) {
            System.out.println(res.get(i));//res k ek ek element ko print kar raha hai
        }
    }
}