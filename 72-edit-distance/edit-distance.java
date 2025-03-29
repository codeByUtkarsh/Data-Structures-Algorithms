class Solution {
    public int minNoOp(int i,int j, String s,String t,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return dp[i][j]= minNoOp(i-1,j-1,s,t,dp);
        //insert
        int in = 1+minNoOp(i,j-1,s,t,dp);
        int dl = 1+minNoOp(i-1,j,s,t,dp);
        int re = 1+minNoOp(i-1,j-1,s,t,dp);
        return  dp[i][j] = Math.min(in,Math.min(dl,re));
    }
    public int minDistance(String str1, String str2) {
        int n = str1.length(),m = str2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minNoOp(n-1,m-1,str1,str2,dp);
    }
}