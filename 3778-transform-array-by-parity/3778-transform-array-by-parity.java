class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = nums[i]%2==1?1:0;
        }
        Arrays.sort(ans);
        return ans;
    }
}