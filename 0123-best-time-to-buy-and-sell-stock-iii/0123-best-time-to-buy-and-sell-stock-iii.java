class Solution {
    public int findMP(int day, int buy, int[] prices, int cap,int[][][] dp) {
        if (cap == 0)
            return 0;
        if (day == prices.length)
            return 0;
        if (dp[day][buy][cap] != -1)
            return dp[day][buy][cap];
        int profit = 0;
        if (buy == 1) {
            int buyy = -prices[day] + findMP(day + 1, 0, prices, cap,dp);
            int notBuy = findMP(day + 1, 1, prices, cap,dp);
            profit = Math.max(buyy, notBuy);
        } else {
            int sell = prices[day] + findMP(day + 1, 1, prices, cap - 1,dp);
            int notSell = findMP(day + 1, 0, prices, cap,dp);
            profit = Math.max(sell, notSell);
        }
        return dp[day][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return findMP(0, 1, prices, 2,dp);
    }
}