class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        int buyy = -prices[day] + dp[day + 1][0][cap];
                        int notBuy = dp[day + 1][1][cap];
                        dp[day][buy][cap] = Math.max(buyy, notBuy);
                    } else {
                        int sell = prices[day] + dp[day+1][1][cap-1];
                        int notSell = dp[day + 1][0][cap];
                        dp[day][buy][cap]= Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}