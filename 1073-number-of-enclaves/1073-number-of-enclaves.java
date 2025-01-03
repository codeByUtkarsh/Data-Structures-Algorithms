class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution { 
    public void bfs( Queue<Pair> q, int[][] grid,int[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        int[] delRow = {0,-1,0,1};
        int[] delCol = {-1,0,1,0};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int row = curr.first;
            int col  = curr.second;
            for(int i=0;i<delRow.length;i++){
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] vis = new int[m][n];
      Queue<Pair> q = new LinkedList<>();
      for(int j=0;j<n;j++){
        if(grid[0][j]==1 && vis[0][j]==0){
            q.add(new Pair(0,j));
            vis[0][j]=1;
        }
        if(grid[m-1][j]==1 && vis[m-1][j]==0){
            q.add(new Pair(m-1,j));
            vis[m-1][j]=1;
        }
      }
      for(int i=0;i<m;i++){
        if(grid[i][0]==1 && vis[i][0]==0){
            q.add(new Pair(i,0));
            vis[i][0]=1;
        }
        if(grid[i][n-1]==1 && vis[i][n-1]==0){
            q.add(new Pair(i,n-1));
            vis[i][n-1]=1;
        }
      }
      bfs(q,grid,vis);
      int cnt =0;
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1 && vis[i][j]==0){
                cnt++;
            }
        }
      }
      return cnt;
    }
}