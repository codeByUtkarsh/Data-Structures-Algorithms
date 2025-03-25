class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int[] curr = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)) curr[j] = 1 + dp[j-1];
                else curr[j] = Math.max(dp[j],curr[j-1]);
            }
            dp = curr;
        }
        return dp[n];
    }
}