class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int num:nums){
            sum+=num;
        }
        int n = nums.length;
        if(sum%2==1) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if(nums[0]<=target) dp[nums[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] temp = new boolean[target+1];
            temp[0] = true;
            for(int j=1;j<=target;j++){
                boolean take = false;
                if(j>=nums[i]) take = dp[j-nums[i]];
                boolean notTake = dp[j];
                temp[j] = take || notTake;
            }
            dp = temp;
        }
        return dp[target];
    }
}