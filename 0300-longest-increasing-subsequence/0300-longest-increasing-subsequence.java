class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
       int[] dp = new int[n+1];
        for(int ind=n-1;ind>=0;ind--){
            int[] curr = new int[n+1];
            for(int prev = ind-1;prev>=-1;prev--){
                int len = dp[prev+1];
                if(prev==-1 || arr[ind]>arr[prev]){
                    len = Math.max(len,1+dp[ind+1]);
                }
                curr[prev+1] = len;
            }
            dp = curr;
        }
        return dp[0];
    }
}