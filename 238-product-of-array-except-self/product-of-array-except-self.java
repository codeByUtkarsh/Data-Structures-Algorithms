class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int ans[] = new int[n];

        ans[0] = ans[n-1] =1;

        int curr=1;
        for(int i=1;i<n;i++){
            curr*=nums[i-1];
             ans[i] = curr;
        }
        curr=1;
        for(int i=n-2;i>-1;i--){
            curr *= nums[i+1];
            ans[i]*=curr;   
            
        }
        return ans;

    }
}