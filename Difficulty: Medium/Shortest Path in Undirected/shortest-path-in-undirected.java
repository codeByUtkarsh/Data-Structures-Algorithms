//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    
    public void bfs(int src,ArrayList<ArrayList<Integer>> adj,int[] path ){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        path[src]=0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.node;
            int dist = curr.dist;
            for(int it:adj.get(node)){
                if(path[it]>dist+1){
                    path[it]=path[node]+1;
                    q.add(new Pair(it,dist+1));
                }
            }
        }
    }

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int n = adj.size();
        int[] shortPath = new int[n];
        for(int i=0;i<n;i++){
            shortPath[i] = Integer.MAX_VALUE;
        }
        bfs(src,adj,shortPath);
        for (int i = 0; i < shortPath.length; i++) {
            if (shortPath[i] == Integer.MAX_VALUE) {
                shortPath[i] = -1;
            }
        }
        return shortPath;
    }
}
