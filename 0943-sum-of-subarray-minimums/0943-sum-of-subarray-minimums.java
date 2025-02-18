class Solution {
    public int[] findNse(int[] arr){
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        } 
        return nse;
    }
    public int[] findPse(int[] arr){
        int n = arr.length;
        int pse[] = new int[n];
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
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        int total=0;
        int mod = (int) 1e9+7,n=arr.length;
        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            total = (total + (int)((left * right * 1L * arr[i]) % mod)) % mod;
        }
        return total;
    }
}