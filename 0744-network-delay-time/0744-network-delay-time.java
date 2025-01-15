class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int src =k;
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)-> x.first-y.first);
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] dist = new int[n+1];
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            adj.get(u).add(new Pair(wt,v));
        }
        for(int i=0;i<n+1;i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        q.add(new Pair(0,src));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int upDis = curr.first;
            int upNode = curr.second;
            for(Pair it:adj.get(upNode)){
                int currDis = it.first;
                int currNode = it.second;
                int total = upDis+currDis;
                if((total)<dist[currNode]){
                    dist[currNode]=total;
                    q.add(new Pair(total,currNode));
                }
            }
        }
        int minDis = -1;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)(1e9)){
                return -1;
            }
            minDis = Math.max(minDis,dist[i]);
        }
        return minDis;
    }
}