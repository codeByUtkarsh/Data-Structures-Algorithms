class Solution {
    public int findMinPath(int i,int j,List<List<Integer>> triangle,int[][] dp,int n){
        if(i==n-1) return triangle.get(n-1).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down = triangle.get(i).get(j) + findMinPath(i+1,j,triangle,dp,n);
        int dg = triangle.get(i).get(j) + findMinPath(i+1,j+1,triangle,dp,n);
        return dp[i][j] = Math.min(down,dg);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
       return findMinPath(0,0,triangle,dp,n);
    }
}