class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i=0;i<n;i++){
            for(int prev = 0; prev<i;prev++){
                if(arr[prev]<arr[i]){
                    dp[i] = Math.max(1+dp[prev],dp[i]);
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}