class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nge = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<n;i++){
            int el = nums1[i];
            if(map.containsKey(el)){
                nge[i] = map.get(el);
            }else{
                nge[i] = -1;
            }
        }
        return nge;
    }
}