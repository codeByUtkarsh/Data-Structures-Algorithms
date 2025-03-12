class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num>=0 && num<n){
                ans[i] = nums[nums[i]];
            }
        }
        return ans;
    }
}