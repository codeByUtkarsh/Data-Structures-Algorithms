class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        int n = nums.length();
        if(k==n) return "0";
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0'>nums.charAt(i)-'0'){
                st.pop();
                k--;
            }

            st.push(nums.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int i=0;
        while(i<sb.length() && sb.charAt(i)=='0'){
            i++;
        }
        String ans = sb.substring(i);
        return ans.isEmpty()?"0":ans;
    }
}