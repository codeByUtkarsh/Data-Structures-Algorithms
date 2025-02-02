class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0,high = n-1;
        int min_value = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low]<=nums[high]){
                min_value = Math.min(min_value,nums[low]);
                break;
            }
            if(nums[low]<=nums[mid]){
                min_value = Math.min(min_value,nums[low]);
                low=mid+1;
            }else{
                min_value= Math.min(min_value,nums[mid]);
                high = mid-1;
            }
        }
        return min_value;
    }
}