class Solution {
    public int findTargetSumWays(int[] nums, int target1) {
        int n = nums.length;
        int totalSum = 0;
        for(int it:nums){
            totalSum+=it;
        }
        int target = (totalSum-target1)/2;
        if((totalSum-target1)<0 || (totalSum-target1)%2==1) return 0;
        int[][] dp = new int[n][target+1];
        if(nums[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]] =1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int notTake = dp[i-1][j];
                int take =0;
                if(nums[i]<=j) take = dp[i-1][j-nums[i]];
                dp[i][j] = take+notTake;
            }
        }
        return dp[n-1][target];
    }
}