class Solution {
    public int findMC(int i,int j, int[] nums,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = nums[i-1]*nums[ind]*nums[j+1]+findMC(i,ind-1,nums,dp)+findMC(ind+1,j,nums,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[newNums.length-1] =1;
        int  ind =1;
        for(int i=0;i<n;i++){
            newNums[ind++] = nums[i];
        }
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return findMC(1,n,newNums,dp);
    }
}