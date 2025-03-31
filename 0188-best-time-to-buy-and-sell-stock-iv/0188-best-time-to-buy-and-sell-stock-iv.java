class Solution {
    public int findMP(int day,int buy,int cap,int[] prices,int[][][] dp){
        if(cap==0) return 0;
        if(day==prices.length) return 0 ;
        if (dp[day][buy][cap] != -1)
            return dp[day][buy][cap];
        if(buy==1){
            int take = -prices[day] + findMP(day+1,0,cap,prices,dp);
            int notTake = findMP(day+1,1,cap,prices,dp);
            return dp[day][buy][cap]= Math.max(take,notTake);
        }else{
            int sell = prices[day] + findMP(day+1,1,cap-1,prices,dp);
            int notSell = findMP(day+1,0,cap,prices,dp);
            return dp[day][buy][cap] = Math.max(sell,notSell);
        }
    }
    public int maxProfit(int k, int[] prices) {   
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return findMP(0,1,k,prices,dp);
    }
}