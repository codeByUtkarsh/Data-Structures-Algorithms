class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int c = 0,base=2;
        StringBuilder ans = new StringBuilder();
        while(i>=0 || j>=0 || c==1){
            int t1 =0,t2=0,sum;
            if(i>=0) t1 = a.charAt(i--)-'0';
            if(j>=0) t2 = b.charAt(j--)-'0';
            sum = t1+t2+c;
            if(sum>=2){
                c=1;
                sum-=base;
            }else{
                c=0;
            }
            ans.append(sum);
        }
        return ans.reverse().toString();
    }
}