class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) return heights[0];
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        //next smaller element array 
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }

        //empty the stack before use in pse
        while(st.size()>0){
            st.pop();
        }

        //previous smaller element 
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        int maxArea = -1;
        for(int i=0;i<n;i++){
            int prev = pse[i]+1;
            int next = nse[i]-1;
            maxArea = Math.max(maxArea,heights[i]*(next-prev+1));
        }
        return maxArea;
    }
}