class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }else {
                while(!st.isEmpty() && st.peek()>0 &&  Math.abs(asteroids[i])>st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && Math.abs(asteroids[i])==st.peek()){
                    st.pop();
                }else if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
            }
        }
        if(st.size()==0) return new int[]{};
        int[] ans = new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}