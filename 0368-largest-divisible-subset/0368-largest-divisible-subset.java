class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi = 1,lastIndex=0;
        for(int i=0;i<n;i++){
            hash[i] = i;
            dp[i]=1;
            for(int prev =0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        return list;
    }
}