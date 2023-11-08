class Solution {
    public int lis(int[]nums , int[] arr2){
        int n = nums.length;
        int m = arr2.length;

        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //valid condition
                if(nums[i-1]== arr2[j-1]){
                    dp[i][j]= dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int[] arr2 = new int[set.size()];
        int i=0;
        for(int num:set){
            arr2[i]=num;
            i++;
        }
        Arrays.sort(arr2);

        return lis(nums,arr2);
    }
}