class Solution {
    public int binarySearch(int low,int high,int target,int[] nums ){
        if(low>high) return -1;
        int mid =(low+high)/2;
        if(target==nums[mid])return mid;
        else if(target>nums[mid]){
            low =  mid+1;
            return binarySearch(low,high,target,nums);
        }else{
            return binarySearch(low,mid-1,target,nums);
        }
    }
    public int search(int[] nums, int target) {
        int low =0,high = nums.length-1;
        return binarySearch(low,high,target,nums);
    }
}