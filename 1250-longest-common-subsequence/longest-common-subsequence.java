class Solution {
    public int lcs(String str1,String str2,int n,int m,int[][] dp){

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){

                //last character is equal
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();

        int[][] dp = new int[n+1][m+1];
        return lcs(text1,text2,n,m,dp);
    }
}