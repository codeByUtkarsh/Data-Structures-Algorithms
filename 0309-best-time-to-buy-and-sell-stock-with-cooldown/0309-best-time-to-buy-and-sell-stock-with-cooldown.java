class Solution {
    public int findMP(int day, int buy, int n, int[] prices, int[][] dp) {
        if (day >= n)
            return 0;
        if (dp[day][buy] != -1)
            return dp[day][buy];
        if (buy == 1) {
            return dp[day][buy] = Math.max(-prices[day] + findMP(day + 1, 0, n, prices, dp),
                    findMP(day + 1, 1, n, prices, dp));
        } else {
            return dp[day][buy] = Math.max(prices[day] + findMP(day + 2, 1, n, prices, dp),
                    findMP(day + 1, 0, n, prices, dp));
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findMP(0, 1, n, prices, dp);
    }
}