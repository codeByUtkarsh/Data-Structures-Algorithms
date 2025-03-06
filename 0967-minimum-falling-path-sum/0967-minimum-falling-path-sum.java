class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int j=0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int ld = (int) 1e9;
                int rd = (int) 1e9;
                int u = matrix[i][j] + dp[i-1][j];
                if(j-1>=0) ld = matrix[i][j] + dp[i-1][j-1];
                if(j+1<m) rd = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.min(u,Math.min(ld,rd));
            }
        }
        int minPath = dp[n-1][0];
        for(int j=1;j<m;j++){
            minPath = Math.min(minPath,dp[n-1][j]);
        }
        return minPath;
    }
}