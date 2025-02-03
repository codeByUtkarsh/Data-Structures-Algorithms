class Solution {
    public int findMax(int[] arr){
        int high = Integer.MIN_VALUE;
        for(int it:arr){
            high = Math.max(high,it);
        }
        return high;
    }
    public int reqTime(int[] arr,int b){
        int totalHr = 0;
        for(int it:arr){
            totalHr+=Math.ceil((double) it/(double) b);
        }
        return totalHr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1,high=findMax(piles),ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            int totalHours = reqTime(piles,mid);
            if(totalHours<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}