class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1) ans.add(nums[dq.peekFirst()]);
        }
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}