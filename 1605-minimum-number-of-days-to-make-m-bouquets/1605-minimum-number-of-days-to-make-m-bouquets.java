class Solution {
    public boolean possible(int[] arr,int day ,int m,int k){
        int cnt=0,nB=0;
        for(int it:arr){
            if(it<=day){
                cnt++;
            }else{
                nB+=(cnt/k);
                cnt=0;
            }
        }
        nB += (cnt / k);
        return nB >= m;
    }
    public int[] findMinMax(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int it:arr){
            min = Math.min(min,it);
            max = Math.max(max,it);
        }
        return new int[]{min,max};
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m*(long) k>n) return -1;
        int[] arr = findMinMax(bloomDay);
        int low = arr[0],high = arr[1];
        while(low<= high){
            int mid = low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}