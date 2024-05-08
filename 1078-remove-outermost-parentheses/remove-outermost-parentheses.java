class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ns = new StringBuilder("");
        boolean outer = false;
        int inner =0;
        for(int i = 0; i<s.length() ;i++){
            char ch = s.charAt(i);
            if( ch == '(' && outer == false){
                outer = true;
                continue;
            }else if(outer == true && ch == '('){
                inner+=1;
                ns.append(ch);
            }else if(outer == true && inner>0 && ch == ')'){
                inner--;
                ns.append(ch);
            }else if(outer == true && inner==0 && ch == ')'){
                outer = false;
            }
        }
        return ns.toString();
    }
}