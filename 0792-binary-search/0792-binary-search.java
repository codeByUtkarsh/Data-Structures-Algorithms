class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length-1;
        int low = 0 ,high = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            else if(target>nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}