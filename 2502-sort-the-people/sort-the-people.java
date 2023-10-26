class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> hm = new HashMap<>();
        int n = names.length;
        for(int i=0;i<names.length;i++){
            hm.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] s = new String[names.length];

        for(int i=n-1,j=0;i>=0;i--,j++){
            s[j]=hm.get(heights[i]);
        }
        return s;
    }
}