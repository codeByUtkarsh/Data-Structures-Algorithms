class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i] + ((i-2)<0?0:dp[i-2]);
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[n-1];
    }
}