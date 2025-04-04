class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[day][buy] = Math.max(-prices[day]+ dp[day + 1][0],dp[day + 1][1]);
                } else {
                    dp[day][buy] = Math.max(prices[day]- fee + dp[day + 1][1],dp[day + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}