class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n= s.length();
        if(n==1) return true;
        
        String p = "";
        for(int i=n-1;i>=0;i--){
            p+= s.charAt(i);
        } 
        if(!s.equals(p)) return false;
        return true;
    }
}