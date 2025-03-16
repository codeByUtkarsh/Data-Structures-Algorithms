class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    return "";
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}