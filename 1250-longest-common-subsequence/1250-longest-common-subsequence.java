class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length() , m = str2.length();
        int[] dp = new int[m+1];
        for(int j=0;j<=m;j++) dp[j]=0;
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) curr[j] = 1+dp[j-1];
                else curr[j] = Math.max(dp[j],curr[j-1]);
            }
            dp = curr;
        }
        return dp[m];
    }
}