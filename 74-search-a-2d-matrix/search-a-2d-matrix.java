class Solution {
    public boolean binarySearch(int[] nums,int target){
        int s = 0,e = nums.length-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]<target) s=mid+1;
            else e=mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix[i],target)){
                return true;
            }
        }
        return false;
    }
}