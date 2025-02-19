class Solution {
    private int lRectangle(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        //next smaller element (n-1->0)
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        
        //empty the stack
        while(st.size()>0){
            st.pop();
        }

        //previous smaller element
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        
        //find max rectangle
        int maxR = 0;
        for(int i=0;i<n;i++){
            int prev = pse[i]+1;
            int next = nse[i]-1;
            maxR = Math.max(maxR,arr[i]*(next-prev+1));
        }
        return maxR;
    }
    public int maximalRectangle(char[][] matrix) {
         int n = matrix.length,m=matrix[0].length;
         int[][] pSum = new int[n][m];
         for(int j=0;j<m;j++){
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += matrix[i][j]-'0';
                if(matrix[i][j]=='0') sum=0;
                pSum[i][j] = sum;
            }
         }
         int maxArea = 0;
         for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea , lRectangle(pSum[i]));
         }
         return maxArea;
    }
}