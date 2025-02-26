class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if(n==1) return new int[]{-1};
        int[] ans = new int[n];
        int greater = -1;
        for(int i=n-1;i>=0;i--){
            int temp = arr[i];
            ans[i] = greater;
            greater = Math.max(greater,temp);
        }
        return ans;
    }
}