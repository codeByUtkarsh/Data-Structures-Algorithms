class Solution {
    public boolean checkPossible(String str1,String str2){
        if(str1.length()!=str2.length()+1) return false;
        int first =0,second=0;
        while(first<str1.length()){
            if( second<str2.length() && str1.charAt(first)==(str2.charAt(second))){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first==str1.length() && second==str2.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi =1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(checkPossible(words[i],words[prev]) && dp[i]<dp[prev]+1){
                    dp[i] = 1+dp[prev];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}