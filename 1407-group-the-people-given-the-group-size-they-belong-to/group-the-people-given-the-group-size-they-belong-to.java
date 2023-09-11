class Solution {
    public List<List<Integer>> groupThePeople(int[] group) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = group.length;
        for(int i=0;i<n;i++){
            if(n>0){
                int size = group[i];
                List<Integer> temp = new ArrayList<>();
                for(int j=0;j<n && temp.size()<size;j++){
                    if(group[j]==size){
                        temp.add(j);
                        group[j]=0;
                    }
                }
                if(temp.size()>0) ans.add(temp);
            }
        }
        return ans;
    }
}