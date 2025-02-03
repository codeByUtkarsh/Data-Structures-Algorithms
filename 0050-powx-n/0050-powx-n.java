class Solution {
    public double findPow(double x,int n){
        if(n==0) return 1;
        if(n==1) return x;
        double half = findPow(x,n/2);
        return n%2==0?half*half:half*half*x;
    }
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return findPow(x,n);
    }
}