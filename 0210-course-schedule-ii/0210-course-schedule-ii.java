class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int m = pre.length;
        int V= numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
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
        int[] ans = new int[V];
        int ind=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[ind++] = node;
            for(int it:adj.get(node)){
                in[it]--;
                if(in[it]==0) q.add(it);
            }
        }
        if(ind==V) return ans;
        int[] arr = {};
        return arr;
    }
}