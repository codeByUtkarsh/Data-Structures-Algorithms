class Solution {
    public int findMP(int ind,int trans,int k,int n,int[] prices,int[][] dp){
        if(ind==n || trans==2*k) return 0;
        if(dp[ind][trans]!=-1) return dp[ind][trans];
        if(trans%2==0){
            return dp[ind][trans] = Math.max(-prices[ind]+findMP(ind+1,trans+1,k,n,prices,dp),findMP(ind+1,trans,k,n,prices,dp));
        }else{
            return dp[ind][trans] = Math.max(prices[ind]+findMP(ind+1,trans+1,k,n,prices,dp),findMP(ind+1,trans,k,n,prices,dp));
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findMP(0,0,k,n,prices,dp);
    }
}