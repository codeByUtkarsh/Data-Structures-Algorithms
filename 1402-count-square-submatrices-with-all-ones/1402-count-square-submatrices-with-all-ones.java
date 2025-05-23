class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int j=0;j<m;j++) dp[0][j] = matrix[0][j];
        for(int i=0;i<n;i++) dp[i][0] = matrix[i][0];
        int cnt =0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0) dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cnt+=dp[i][j];
            }
        }
        return cnt;
    }
}