class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int open =0;
        for(char str:s.toCharArray()){
            if(str=='(') st.push(str);
            else if(st.size()>0){
                st.pop();
            }else{
                open++;
            }
        }
        return st.size()+open;
    }
}