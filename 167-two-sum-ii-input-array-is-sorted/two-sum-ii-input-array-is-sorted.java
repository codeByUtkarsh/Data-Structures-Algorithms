class Solution {
    public int[] twoSum(int[] num, int target) {

        
        int ans[] = new int[2];
        for(int i=0;i<num.length-1;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]+num[j]==target){
                    ans[0]=i+1;
                    ans[1]=j+1;
                    return ans;
                }
            }
        }
        return ans;
    }
}