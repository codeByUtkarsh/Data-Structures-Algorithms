class Pair{
    long first;
    int second;
    public Pair(long first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        if(n==1) return 1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)->Long.compare(x.first,y.first));
        int[] ways = new int[n];
        long[] dist = new long[n];
        int MOD = (int)1e9 + 7;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        for(int i=0;i<n;i++){
            dist[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        ways[0]=1;
        dist[0]=0;
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            long upDis = curr.first;
            int upNode = curr.second;
            for(Pair it:adj.get(upNode)){
                long currDis = it.first;
                int currNode = it.second;
                long totalDis = upDis+currDis;
                if(totalDis<dist[currNode]){
                    dist[currNode]=totalDis;
                    q.add(new Pair(totalDis,currNode));
                    ways[currNode]=ways[upNode];
                }else if(totalDis == dist[currNode]){
                    ways[currNode]= (ways[currNode]+ways[upNode])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}