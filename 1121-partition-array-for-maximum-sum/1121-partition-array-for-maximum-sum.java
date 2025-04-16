class Solution {
    public int findMax(int i,int n,int[] arr,int k,int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int ans ,maxi;
        ans = maxi = Integer.MIN_VALUE;
        int len =0;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi)+findMax(j+1,n,arr,k,dp);
            ans = Math.max(ans,sum);
        }
        return dp[i]=ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return findMax(0,n,arr,k,dp);
    }
}