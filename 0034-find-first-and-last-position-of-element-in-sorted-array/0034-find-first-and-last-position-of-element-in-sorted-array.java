class Solution {
    public int findLB(int low,int high,int[] nums,int target){
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=target){
                ans = mid;
                high = mid-1;
             }
             else{
                low=mid+1;
             }
        }
        return ans;
    }
    public int findUB(int low,int high, int[] nums,int target){
        int ans=-1;
        while(low<=high){
             int mid = low+(high-low)/2;
            if(nums[mid]>target){
                ans = mid;
                high = mid-1;
             }
             else{
                low=mid+1;
             }
        } 
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n= nums.length;
        int low =0,high = n-1;
        int lb = findLB(low,high,nums,target); 
        if(lb==-1 || nums[lb]!=target) return new int[]{-1,-1};
        int ub = findUB(low,high,nums,target);
        if (ub == -1) ub = n;
        return new int[]{lb,ub-1};
    }
}