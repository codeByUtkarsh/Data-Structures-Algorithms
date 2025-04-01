class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * k + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int trans = 2 * k - 1; trans >= 0; trans--) {
                if (trans % 2 == 0) {
                    dp[ind][trans] = Math.max(-prices[ind] + dp[ind + 1][trans + 1],dp[ind + 1][trans]);
                } else {
                    dp[ind][trans] = Math.max(prices[ind] + dp[ind + 1][trans + 1],dp[ind + 1][trans]);
                }
            }
        }
        return dp[0][0];
    }
}