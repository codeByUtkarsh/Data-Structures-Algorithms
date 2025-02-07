class Solution {
    private int findSplit(int[] arr, int currNum){
        int split = 1;
        long size =0;
        for(int i=0;i<arr.length;i++){
            if(size+arr[i]<=currNum){
                size+=arr[i];
            }else{
                split++;
                size = arr[i];
            }
        }
        return split;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k>n) return -1;
        int high = 0;
        int max = Integer.MIN_VALUE;
        for(int it:nums){
            high+=it;
            max = Math.max(it,max);
        }
        int low = max;
        while(low<=high){
            int mid = low+(high-low)/2;
            int totalSplit = findSplit(nums,mid);
            if(totalSplit>k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}