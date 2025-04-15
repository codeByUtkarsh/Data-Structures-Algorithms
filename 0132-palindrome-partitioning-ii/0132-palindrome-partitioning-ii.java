class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        boolean[][] isPal = new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i <= 1) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i+1][j-1];
                    }
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            int minCost = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPal[i][j]){
                    int cost = 1+dp[j+1];
                    minCost = Math.min(minCost,cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0]-1;
    }
}