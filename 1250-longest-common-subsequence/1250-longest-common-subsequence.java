class Solution {
    public int findlcs(int i,int j, String str1,String str2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(str1.charAt(i)==str2.charAt(j)) return dp[i][j] = 1 + findlcs(i-1,j-1,str1,str2,dp);
        return dp[i][j] = Math.max(findlcs(i-1,j,str1,str2,dp),findlcs(i,j-1,str1,str2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findlcs(n-1,m-1,text1,text2,dp);
    }
}