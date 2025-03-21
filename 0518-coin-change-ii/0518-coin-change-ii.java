class Solution {
    public int findWays(int ind,int[] arr,int target,int[][] dp){
        if(ind==0){
            return (target%arr[0]==0)?1:0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int notTake = findWays(ind-1,arr,target,dp);
        int take =0;
        if(arr[ind]<=target) take = findWays(ind,arr,target- arr[ind],dp);
        return dp[ind][target]=(take+notTake);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp =new int[n][amount+1];
        for(int target=0;target<=amount;target++){
            if(target%coins[0]==0) dp[0][target]=1;
            else dp[0][target]=0;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
        int take =0;
        if(coins[i]<=j) take = dp[i][j-coins[i]];
        dp[i][j]=(take+notTake);
            }
        }
        return dp[n-1][amount];
    }
}