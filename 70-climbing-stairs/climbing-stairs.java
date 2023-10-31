class Solution {
    public int countWays(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = countWays(n-1,dp)+countWays(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        return countWays(n,dp);     
    }
}