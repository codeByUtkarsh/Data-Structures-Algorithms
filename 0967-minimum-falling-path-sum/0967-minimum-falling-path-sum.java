class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];
        for(int j=0;j<m;j++){
            dp[j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            int[] temp = new int[m];
            for(int j=0;j<m;j++){
                int u =  dp[j];
                int ld =  (j-1>=0)?dp[j-1]:Integer.MAX_VALUE;
                int rd = (j+1<m)?dp[j+1]:Integer.MAX_VALUE;
                temp[j] = matrix[i][j]+ Math.min(u,Math.min(ld,rd));
            }
            dp = temp;
        }
        int minPath = dp[0];
        for(int j=1;j<m;j++){
            minPath = Math.min(minPath,dp[j]);
        }
        return minPath;
    }
}