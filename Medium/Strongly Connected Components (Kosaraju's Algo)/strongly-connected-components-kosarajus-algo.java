//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static void dfs(ArrayList<ArrayList<Integer>> transpose,boolean[] vis,int curr){
        vis[curr]= true;
        
        for(int i=0;i<transpose.get(curr).size();i++){
            int edge = transpose.get(curr).get(i);
            if(!vis[edge]){
                dfs(transpose,vis,edge);
            }
        }
    }
    public static void topSort(ArrayList<ArrayList<Integer>> graph,boolean[] vis,Stack<Integer> s,int curr){
        vis[curr]=true;
        
        for(int i=0;i<graph.get(curr).size();i++){
            int edge = graph.get(curr).get(i);
            if(!vis[edge]){
                topSort(graph,vis,s,edge);
            }
        }
        s.push(curr);
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        //code here
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        
        //step1 Get nodes in stack
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSort(graph,vis,s,i);
            }
        }
        
        //Transpose of graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            vis[i]=false;
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<graph.get(i).size();j++){
                int v = graph.get(i).get(j);
                transpose.get(v).add(i);
            }
        }
        
        //Step 3 (Do dfs according to stock nodes)
        int count=0;
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transpose,vis,curr);
                count++;
            }
        }
        return count;
    }
}
