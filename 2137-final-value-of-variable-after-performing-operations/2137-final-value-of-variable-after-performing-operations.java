class Solution {
    public int finalValueAfterOperations(String[] o) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("--X",-1);
        map.put("X--",-1);
        map.put("X++",1);
        map.put("++X",1);
        int sum =0;
        for(String st:o){
            sum+= map.get(st);
        }
        return sum;
        
    }
}