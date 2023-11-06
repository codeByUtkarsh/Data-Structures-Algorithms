class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int sum = amount;
        int dp[][] = new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        } 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){ //valid
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j]; 
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}