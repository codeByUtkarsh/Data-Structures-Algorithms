class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) temp[j]=1;
                else{
                    int up = 0;
                    int left =0;
                    if(i>0 && obstacleGrid[i-1][j]!=1) up = dp[j];
                    if(j>0 && obstacleGrid[i][j-1]!=1) left = temp[j-1];
                    temp[j] = up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}