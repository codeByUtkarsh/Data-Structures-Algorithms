class Solution {
    static int getMax(int[] freq){
        int max = 0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0) max = Math.max(max,freq[i]);
        }
        return max;
    }

    static int getMin(int[] freq){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0)  min = Math.min(min,freq[i]);
        }
        return min;
    }

    public int beautySum(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            int freq[] = new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int max = getMax(freq);
                int min = getMin(freq);

                int beauty = (max-min);
                res+=beauty;
            }
        }
        return res;
    }
}