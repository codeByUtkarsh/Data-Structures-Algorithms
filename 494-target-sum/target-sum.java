class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum =0;
        for(int it:nums){
            sum+=it;
        }
        if(Math.abs(target) > sum) return 0;
        if((sum + target) % 2 != 0) return 0;
        sum = (sum+target)/2;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}