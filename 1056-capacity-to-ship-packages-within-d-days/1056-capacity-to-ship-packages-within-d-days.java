class Solution {
    private int findDays(int[] arr,int cap){
        int days=0 ,load=0;
        for(int it:arr){
            int totalLoad = load+it;
            if(totalLoad>cap){
                days++;
                load = it;
            }else{
                load+=it;
            }
        }
        return days+1;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int totalWeights =0;
        for(int it:weights){
            max = Math.max(max,it);
            totalWeights+=it;
        }
        int low = max,high = totalWeights;
        while(low<=high){
            int mid = low+(high-low)/2;
            int totalDay = findDays(weights,mid);
            if(totalDay<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}