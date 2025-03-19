class Solution {
    public int noOfFewCoins(int ind,int[] coins,int amount,int[][] dp){
        if(amount==0) return 0;
        if(ind==0){
            if(amount%coins[ind]==0) return amount/coins[ind];
            else return (int) 1e9;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int notTake = 0 + noOfFewCoins(ind-1,coins,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=amount) take = 1 + noOfFewCoins(ind,coins,amount-coins[ind],dp);
        return dp[ind][amount]= Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int result =  noOfFewCoins(n-1,coins,amount,dp);
        return result>=(int) 1e9?-1:result;
    }
}