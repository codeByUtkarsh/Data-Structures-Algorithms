class Solution {
    public String baseNeg2(int n) {
        if(n==0) return "0";
        StringBuilder res = new StringBuilder();
        while(n!=0){
            int rem = n%-2;
             n = n/(-2);
             if(rem<0){
                rem+=2;
                n+=1;
             }
             res.append(rem);
        }
        return res.reverse().toString();
    }
}