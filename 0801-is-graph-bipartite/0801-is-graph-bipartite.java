class Solution {
    public boolean check(int start,int V,int[][] adj,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it:adj[node]){
                if(color[it]==-1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[m];
        for(int i=0;i<m;i++) color[i]=-1;
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(check(i,m,graph, color)==false){
                    return false;
                }
            }
        }
        return true;
    }

}