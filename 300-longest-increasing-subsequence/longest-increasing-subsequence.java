class Solution {
    public int lis(int ind,int prev,int n,int[] nums,int[][] dp){
        if(ind==n) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int len = lis(ind+1,prev,n,nums,dp);
        if(prev==-1 || nums[ind]>nums[prev]){
            len = Math.max(len,1+lis(ind+1,ind,n,nums,dp));
        }
        return dp[ind][prev+1] =  len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lis(0,-1,n,nums,dp);
    }
}