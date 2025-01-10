class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int m = pre.length;
        int V= numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int in[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                in[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int it:adj.get(node)){
                in[it]--;
                if(in[it]==0) q.add(it);
            }
        }
        if(cnt==V) return true;
        return false;
    }
}