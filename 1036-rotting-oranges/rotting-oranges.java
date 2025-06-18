class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public void bfs(int i,int j,int[][] vis, int[][] grid,int[] minTime,int[] cnt,Queue<Pair> q){
        int n = grid.length;
        int m = grid[0].length;
        
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minTime=0;
        int freshCnt = 0;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    freshCnt++;
                }
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            int time = pair.time;
            System.out.println(row+" "+col);
            minTime = Math.max(minTime,time);
            int[] delRow = {0,1,0,-1};
            int[] delCol = {1,0,-1,0};
            for(int k=0;k<delRow.length;k++){
                int nrow = row+delRow[k];
                int ncol = col+delCol[k];
                System.out.println(nrow+" "+ncol);
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=2; 
                    cnt++;
                    q.offer(new Pair(nrow,ncol,time+1));
                }
            }
        }
        return (freshCnt!=cnt)?-1:minTime;
    }
}