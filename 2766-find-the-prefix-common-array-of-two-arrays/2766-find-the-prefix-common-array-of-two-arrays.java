class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> st = new HashSet<>();
        int n = A.length;
        int m = B.length;
        int[] pre = new int[n];
        for(int i=0;i<n;i++){
            int cnt=0;
            st.add(A[i]);
            for(int j=0;j<=i;j++){
                if(st.contains(B[j])){
                cnt++;
                }
            }
            pre[i]=cnt;
        }
        return pre;
    }
}