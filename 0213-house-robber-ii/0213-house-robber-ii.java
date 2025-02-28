class Solution {
    public int findMaxRob(List<Integer> nums){
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int take = nums.get(i) + prev2;
            int notTake = 0 + prev;
            int curri = Math.max(take,notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0) list1.add(nums[i]);
            if(i!=n-1) list2.add(nums[i]);
        }
        return Math.max(findMaxRob(list1),findMaxRob(list2));
    }
}