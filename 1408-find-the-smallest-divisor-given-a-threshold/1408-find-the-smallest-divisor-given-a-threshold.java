class Solution {
    private boolean possible(int[] nums,int d,int t){
        double cnt = 0;
        for(int it:nums){
            cnt+= Math.ceil((double) it/ d);
        }
        return cnt<=t;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int it:nums){
            max = Math.max(max,it);
        }
        int low=1,high=max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(nums,mid,threshold)){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}