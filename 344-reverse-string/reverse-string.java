class Solution {
    public void reverse(char[] s,int i,int n){
        if(i>=n) return;
        char temp = s[i];
        s[i]=s[n];
        s[n]=temp;
        reverse(s,i+1,n-1);
    }
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
}