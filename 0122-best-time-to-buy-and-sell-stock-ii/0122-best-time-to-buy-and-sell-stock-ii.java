class Solution {
    public int findMaxProfit(int ind,int buy,int n,int[] prices,int[][] dp){
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1){
            int take = -(prices[ind])+findMaxProfit(ind+1,0,n,prices,dp);
            int notTake = findMaxProfit(ind+1,1,n,prices,dp);
            profit = Math.max(take,notTake);
        }else{
            int take = (prices[ind]) + findMaxProfit(ind+1,1,n,prices,dp);
            int notTake = findMaxProfit(ind+1,0,n,prices,dp);
            profit = Math.max(take,notTake);
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findMaxProfit(0,1,n,prices,dp);
    }
}