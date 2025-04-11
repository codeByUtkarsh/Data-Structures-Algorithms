class Solution {
    public int findMC(int i, int j, int[] cuts,int[][] dp) {
        if (i > j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = cuts[j + 1] - cuts[i - 1] 
                     + findMC(i, ind - 1, cuts,dp) 
                     + findMC(ind + 1, j, cuts,dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length; 
        Arrays.sort(cuts);
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        System.arraycopy(cuts, 0, newCuts, 1, c);
        newCuts[c+1] = n;
        int m = newCuts.length;
        int[][] dp = new int[m][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findMC(1,c,newCuts,dp);
    }
}