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
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findWays(n-1,coins,amount,dp);
    }
}