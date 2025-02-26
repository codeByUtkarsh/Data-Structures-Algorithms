class Solution {
    private int countWays(int ind , int[] dp){
        if(ind==0) return 1;
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left = countWays(ind-1,dp);
        int right = countWays(ind-2,dp);
        return dp[ind] = left+right;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return countWays(n,dp);
    }
}