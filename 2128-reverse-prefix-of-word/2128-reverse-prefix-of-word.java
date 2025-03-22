class Solution {
    public String reversePrefix(String word, char ch) {
        int ind = word.indexOf(ch);
        if(ind!=-1){
            String s = new StringBuilder(word.substring(0,ind+1)).reverse().append(word.substring(ind+1)).toString();
            return s;
        }
        return word;
    }
}