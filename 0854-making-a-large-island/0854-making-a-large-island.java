class DisJointSet {
    List<Integer> par = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisJointSet(int n) {
        for (int i = 0; i <= n; i++) {
            par.add(i);
            size.add(1);
        }
    }

    // find the ultimate parent
    // path compression
    public int findUPar(int node) {
        if (node == par.get(node))
            return node;
        int ulp = findUPar(par.get(node));
        par.set(node, ulp);
        return ulp;
    }

    // union by size
    public void unionBySize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            par.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            par.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

class Solution {

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisJointSet ds = new DisJointSet(n*m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) continue;
                int[] dRow = {-1,0,1,0};
                int[] dCol = {0,1,0,-1};
                for(int ind=0;ind<dRow.length;ind++){
                    int nrow = i+dRow[ind];
                    int ncol = j+dCol[ind];
                    if(isValid(nrow,ncol,n,m) && grid[nrow][ncol]==1){
                        int nodeNo = i*m+j;
                        int adjNode = nrow*m+ncol;
                        ds.unionBySize(nodeNo,adjNode);
                    }
                }
            }
        } 
        
        //step2
        int max =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                int[] dRow = {-1,0,1,0};
                int[] dCol = {0,1,0,-1};
                HashSet<Integer> comp = new HashSet<>();
                for(int ind=0;ind<dRow.length;ind++){
                    int nrow = i+dRow[ind];
                    int ncol = j+dCol[ind];
                    if(isValid(nrow,ncol,n,m) && grid[nrow][ncol]==1){
                        comp.add(ds.findUPar(nrow*n+ncol));
                }
                int totalSize =0;
                for(Integer par:comp){
                    totalSize+=ds.size.get(par);
                }
                max = Math.max(max,totalSize+1);
                }
            }
        }
        for(int i=0;i<n*n;i++){
            max = Math.max(max,ds.size.get(ds.findUPar(i)));
        }
        return max;
    }
}