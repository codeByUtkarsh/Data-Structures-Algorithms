class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list,(a,b)-> b.getValue().compareTo(a.getValue()));
        for(Map.Entry<Character,Integer> e : list){
            int freq =e.getValue();
            while(freq>0){
                ans+=e.getKey();
                freq--;
            }
        }
        return ans;

    }
}