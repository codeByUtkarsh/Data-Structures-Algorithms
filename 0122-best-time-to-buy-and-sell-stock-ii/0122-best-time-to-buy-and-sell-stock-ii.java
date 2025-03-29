class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int take = -(prices[ind]) + dp[ind + 1][0];
                    int notTake =dp[ind+1][1];
                    profit = Math.max(take, notTake);
                } else {
                    int take = (prices[ind]) + dp[ind + 1][1];
                    int notTake = dp[ind +1][0];
                    profit = Math.max(take, notTake);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
}