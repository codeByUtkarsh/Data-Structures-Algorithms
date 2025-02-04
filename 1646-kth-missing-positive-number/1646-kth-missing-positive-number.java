class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0,high=arr.length-1;
        int missing=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            missing = arr[mid]-(mid+1);
            if(missing<k) low=mid+1;
            else high=mid-1;
        }
        return low+k;
    }
}