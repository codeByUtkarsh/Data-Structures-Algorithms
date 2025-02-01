class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        Stack<Integer> st = new Stack<>();
        if(nums[0]%2==0) st.push(0);
        else st.push(1);
        for(int i=1;i<n;i++){
            int num = -1;
            if(nums[i]%2==0){
                num=0;
            }else{
                num=1;
            }
            int check = st.peek();
            if(check == num) return false;
            st.push(num);
        }
        return true;
    }
}