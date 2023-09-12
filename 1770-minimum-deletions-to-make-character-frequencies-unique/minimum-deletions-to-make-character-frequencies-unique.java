class Solution {
    public int minDeletions(String s) {
        int deletion = 0;
        int freqMap[] = new int[26];
        for(int i=0;i<s.length();i++){
            freqMap[s.charAt(i)-'a']++;
        }

        Set<Integer> unique = new HashSet<>();
        for(int i=0;i<freqMap.length;i++){
            while(freqMap[i]>0 && unique.contains(freqMap[i])){
                deletion++;
                freqMap[i]--;
            }
            unique.add(freqMap[i]);
        }
        return deletion;
    }
}