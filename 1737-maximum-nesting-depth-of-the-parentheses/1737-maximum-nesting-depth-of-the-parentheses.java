class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int depth =0;
        int cnt =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                cnt++;
                depth = Math.max(depth,cnt);
                st.push(ch);
            }else if(ch==')'){
                cnt--;
                if(!st.isEmpty()) st.pop();
            }else continue;
        }
        return depth;
    }
}