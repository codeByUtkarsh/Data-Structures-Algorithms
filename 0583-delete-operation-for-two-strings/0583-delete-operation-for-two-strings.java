class Solution {
    public int minDistance(String str1, String str2) {
        int n = str1.length(),m = str2.length();
        int[] dp = new int[m+1];
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) curr[j] = 1+ dp[j-1];
                else curr[j] = Math.max(dp[j],curr[j-1]);
            }
            dp = curr;
        }
        return (n+m-2*dp[m]);
    }
}