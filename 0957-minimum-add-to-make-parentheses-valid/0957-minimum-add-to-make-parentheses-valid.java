class Solution {
    public int minAddToMakeValid(String s) {
        int open =0;
        int close =0;
        for(char str:s.toCharArray()){
            if(str=='(') close++;
            else if(close>0){
                close--;
            }else{
                open++;
            }
        }
        return open+close;
    }
}