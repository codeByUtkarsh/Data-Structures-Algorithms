class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> p = new LinkedList<>();
        int[] ans = new int[nums.length];


        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                q.add(nums[i]);
            }else{
                p.add(nums[i]);
            }
        }

        int i=0;
        while(!q.isEmpty() && !p.isEmpty()){
            ans[i] = q.poll();
            i++;
            ans[i] = p.poll();
            i++;
        }
        return ans;
    }
}