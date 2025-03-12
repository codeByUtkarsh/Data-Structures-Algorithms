class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i=0;
        for(int num:nums){
                ans[i++] = nums[num];
        }
        return ans;
    }
}