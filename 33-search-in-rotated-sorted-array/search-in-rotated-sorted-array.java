class Solution {
    public int search(int[] nums, int target) {
        int s =0;
        int e = nums.length-1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
          hm.put(nums[i],i);
        }
        Arrays.sort(nums);
        while(s<=e){
          int mid=(s+e)/2;
          if(nums[mid]==target){
            return hm.get(nums[mid]);
            }else if(nums[mid]<target){
              s=mid+1;
            }else{
              e=mid-1;
            }
        }
        return -1;
    }
}