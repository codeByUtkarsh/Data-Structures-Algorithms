class Pair{
    String word;
    int steps;
    public Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>();
        int n = wordList.size();
        for(int i=0;i<n;i++ ){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String replacedWord = new String(charArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}