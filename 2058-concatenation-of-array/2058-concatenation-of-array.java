class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n*2];
        int j=0;
        for(int i=0;i<2;i++){
            for(int k=0;k<nums.length;k++){
                ans[j++] = nums[k];
            }
        }
        return ans;
    }
}