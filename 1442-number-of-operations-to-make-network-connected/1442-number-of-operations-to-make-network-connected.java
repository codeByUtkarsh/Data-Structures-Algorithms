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
    public int makeConnected(int n, int[][] con) {
        DisJointSet ds = new DisJointSet(n);
        int extraEdge =0;
        for(int i=0;i<con.length;i++){
            int u = con[i][0];
            int v = con[i][1];
            if(ds.findUPar(u)==ds.findUPar(v)) extraEdge++;
            else{
                ds.unionBySize(u,v);
            }
        }
        int component =0;
        for(int i=0;i<n;i++){
            if(ds.par.get(i)==i) component++;
        }
        int ans = component -1;
        if(extraEdge>=ans){
            return ans;
        }
        return -1;
    }
}