class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;
            int curri = Math.max(pick,notPick);
            prev2 = prev ;
            prev = curri;
        }
        return prev;
    }
}