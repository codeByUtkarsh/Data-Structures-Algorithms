class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        char[] ch = new char[n1+n2];
        int i=0;
        int j=0;
        int k=0;
        while(i<n1 && j<n2){
            ch[k++]= word1.charAt(i++);
            ch[k++]=word2.charAt(j++);

        }
        while(i<n1){
            ch[k++]=word1.charAt(i++);
        }
        while(j<n2){
            ch[k++]= word2.charAt(j++);
        }
        return new String(ch);
    }
}