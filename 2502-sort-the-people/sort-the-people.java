class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String>map=new HashMap<>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[]ans= new String[heights.length];
        int ind=0;
        for(int i=heights.length-1;i>=0;i--){
            ans[ind]=map.get(heights[i]);
            ind++;
        }
        return ans;
    }
}