import java.util.StringTokenizer;
class Solution {
    public int mostWordsFound(String[] sentences) {
        int cnt = Integer.MIN_VALUE;
        for(String st:sentences){
            StringTokenizer token = new StringTokenizer(st);
            int wordCnt = token.countTokens();
            cnt = Math.max(cnt,wordCnt);
        }
        return cnt;
    }
}