class Solution {
    public int singleNumber(int[] nums) {
        int n= nums.length;
        
        boolean check;
        for(int i=0;i<n;i++){
            check = false;
            for(int j=0;j<n;j++){
                if(i!=j && nums[i]==nums[j]){
                    check = true;
                    break;
                }
                
            }
            if(!check) return nums[i];
        }
        return -1;

    }
}