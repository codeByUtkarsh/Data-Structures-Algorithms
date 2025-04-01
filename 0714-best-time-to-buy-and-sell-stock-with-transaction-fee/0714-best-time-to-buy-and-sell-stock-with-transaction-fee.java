class Solution {
    public int findMP(int day,int buy,int n,int f,int[] prices,int[][] dp ){
        if(day==n) return 0;
        if(dp[day][buy]!=-1) return dp[day][buy];
        if(buy==1){
            return dp[day][buy]=Math.max(-prices[day]-f+findMP(day+1,0,n,f,prices,dp),findMP(day+1,1,n,f,prices,dp));
        }else{
            return dp[day][buy]= Math.max(prices[day]+findMP(day+1,1,n,f,prices,dp),findMP(day+1,0,n,f,prices,dp));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findMP(0,1,n,fee,prices,dp);
    }
}