class Solution {
    public int helper(int n,int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = helper(n-1,dp)+helper(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        return helper(n,dp);
    }
}