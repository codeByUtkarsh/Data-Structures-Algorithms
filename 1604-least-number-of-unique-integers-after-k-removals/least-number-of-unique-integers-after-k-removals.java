class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans[] = new int[map.size()];
        int j=0;
        for(int val: map.values()){
            ans[j++] = val;
        }
        Arrays.sort(ans);
        int unique = ans.length;
        for(int i=0;i<ans.length;i++){
            if(k>=ans[i]){
                k-=ans[i];
                unique--;
            }else{
                break;
            }
        }
        return unique;
    }
}