class DisJointSet{
    List<Integer> par = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisJointSet(int n){
        for(int i=0;i<n;i++){
            par.add(i);
            size.add(1);
        }
    }
    //find the ultimate parent 
    public int findUPar(int node){
        if(node == par.get(node)) return node;
        int ulp = findUPar(par.get(node));
        par.set(node,ulp);
        return par.get(node);
    }

    //unionBySize()
    public void unionBySize(int u,int v){
        int ulp_u  = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            par.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }else{
            par.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol =0;
        for(int i=0;i<n;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }    
        DisJointSet ds = new DisJointSet(maxRow+maxCol+2);
        HashMap<Integer,Integer> stoneN = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.unionBySize(nodeRow,nodeCol);
            stoneN.put(nodeRow,1);
            stoneN.put(nodeCol,1);
        }
        int cnt =0;
        for(Map.Entry<Integer,Integer> it : stoneN.entrySet()){
            if(ds.findUPar(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}