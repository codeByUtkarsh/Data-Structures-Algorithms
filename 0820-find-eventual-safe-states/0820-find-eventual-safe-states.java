class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safe = new ArrayList<>();
        int[] indegree = new int[m];
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<m;i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            for(int it:graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        for(int i=0;i<m;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            safe.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        Collections.sort(safe);
        return safe;
    }
}