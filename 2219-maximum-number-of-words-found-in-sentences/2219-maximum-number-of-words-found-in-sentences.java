import java.util.StringTokenizer;
class Solution {
    public int mostWordsFound(String[] sentences) {
        int cnt = Integer.MIN_VALUE;
        for(String st:sentences){
            String[] words = st.split(" ");
            cnt = Math.max(cnt,words.length);
        }
        return cnt;
    }
}