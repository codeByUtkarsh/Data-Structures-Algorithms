class Solution {
    public int[] findNse(int[] arr,int n){
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPse(int[] arr,int n){
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==1) return heights[0];
        int[] nse = findNse(heights,n);
        int[] pse = findPse(heights,n);
        int maxArea = -1;
        for(int i=0;i<n;i++){
            int prev = pse[i]+1;
            int next = nse[i]-1;
            maxArea = Math.max(maxArea,heights[i]*(next-prev+1));
        }
        return maxArea;
    }
}