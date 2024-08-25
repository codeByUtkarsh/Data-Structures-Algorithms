class Solution {
    public void calComSum(int i,int[] cand, int target,List<List<Integer>> ans, List<Integer> temp,int n){
         if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
         }
         if(i==n && target>0){
            return;
         }

         if(cand[i]<=target){
            temp.add(cand[i]);
            calComSum(i,cand,target-cand[i],ans,temp,n);
            temp.remove(temp.size()-1);
         }
          calComSum(i+1,cand,target,ans,temp,n);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        calComSum(0,candidates, target,ans,temp,n);
        return ans;
    }
}