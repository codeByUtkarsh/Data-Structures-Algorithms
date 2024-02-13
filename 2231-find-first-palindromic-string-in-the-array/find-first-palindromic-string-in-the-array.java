class Solution {
    public boolean check(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        String pal ="";
        for(String s:words){
            boolean ispalindrome = check(s);
            if(ispalindrome){
                pal = s;
                break;
            }
            continue;
        } 
        return pal;
    }
}