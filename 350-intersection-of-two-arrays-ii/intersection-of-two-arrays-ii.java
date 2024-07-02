class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int k=0;k<nums2.length;k++){
                if(nums1[i]==nums2[k]){
                    ans.add(nums1[i]);
                    nums2[k]=-1;
                    break;
                }
            }
        }
        int[] a = new int[ans.size()];
        for(int l=0;l<ans.size();l++){
            a[l]=ans.get(l);
        }
        return a;
        
    }
}