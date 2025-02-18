class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            int largest = nums[i],smallest = nums[i];
            for(int j=i+1;j<n;j++){
                largest = Math.max(largest,nums[j]);
                smallest = Math.min(smallest,nums[j]);
                sum=sum+(largest-smallest);
            }
        }
        return sum;
    }
}