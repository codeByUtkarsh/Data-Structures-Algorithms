class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        StringBuilder ans = new StringBuilder(); 
        int c =0;
        while(n1>=0 || n2>=0 || c==1){
            int t1=0,t2=0;
            if(n1>=0){
                t1 = num1.charAt(n1--)-'0';
            }
            if(n2>=0){
                t2 = num2.charAt(n2--)-'0';
            }
            int sum = t1+t2+c;
            if(sum>=10){
                c=1;
                sum=sum%10;
                ans.append(sum);
            }else{
                c=0;
                ans.append(sum);
            }
        }
        return ans.reverse().toString();
    }
}