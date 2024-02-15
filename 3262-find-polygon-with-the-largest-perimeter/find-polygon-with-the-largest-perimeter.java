class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1;
        long total =0;
        for(int i=0;i<nums.length;i++){
            if(total>nums[i]){
                res = total+nums[i];
            }
            total+=nums[i];
        }
        return res;
    }
}