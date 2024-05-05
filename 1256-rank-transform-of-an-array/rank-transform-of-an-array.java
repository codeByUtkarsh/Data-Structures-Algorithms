class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int temp[] = Arrays.copyOf(arr,arr.length);
        
        Arrays.sort(temp);
        Map<Integer,Integer> ind = new HashMap<>();
        int rank=1;
        for(int i=0;i<temp.length;i++){
            if(!ind.containsKey(temp[i])){
                ind.put(temp[i],rank);
                rank++;
            }
        }
        int ans[] = new int[temp.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = ind.get(arr[i]);
        }
        return ans;
    }
}