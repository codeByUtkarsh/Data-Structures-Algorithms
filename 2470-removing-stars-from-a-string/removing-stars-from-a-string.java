class Solution {
    public String removeStars(String st) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);
            if(ch!='*'){
                s.push(ch);
            }else{
                s.pop();
            }
        }
        StringBuilder ns = new StringBuilder("");
        while(!s.isEmpty()){
            char ch = s.pop();
            ns.append(ch);
        } 
        String str = ns.reverse().toString();
        return str;
    }
}