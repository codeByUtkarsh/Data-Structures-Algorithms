class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void dfs(int r,int c,char[][] board, int[][] vis,int[] delRow, int[] delCol){
        int m = board.length;
        int n = board[0].length;
        vis[r][c]=1;
        for(int i=0;i<delRow.length;i++){
            int nrow = r+delRow[i];
            int ncol = c+delCol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,vis,delRow,delCol);
            }
        }
    }
    public void solve(char[][] board) {
      int m = board.length;
      int n = board[0].length;
      int[][] vis = new int[m][n];
      int[] delRow = {0,-1,0,1};
      int[] delCol = {-1,0,1,0};
      for(int j=0;j<n;j++){
        if(board[0][j]=='O' && vis[0][j]==0){
            dfs(0,j,board,vis,delRow,delCol);
        }
        if(board[m-1][j]=='O' && vis[m-1][j]==0){
            dfs(m-1,j,board,vis,delRow,delCol);
        }
      }  
      for(int i=0;i<m;i++){
        if(board[i][0]=='O' && vis[i][0]==0){
            dfs(i,0,board,vis,delRow,delCol);
        }
        if(board[i][n-1]=='O' && vis[i][n-1]==0){
            dfs(i,n-1,board,vis,delRow,delCol);
        }
      }
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(vis[i][j]==0 && board[i][j]=='O'){
                board[i][j]='X';
            }
        }
      }
    }
}