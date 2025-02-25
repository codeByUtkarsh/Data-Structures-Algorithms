class Solution {
    public int numOfSubarrays(int[] arr) {
        int cnt =0,even = 1,odd=0, prefixSum=0;
        int mod = 1_000_000_007;
        for(int a:arr){
            prefixSum+=a;
            if(prefixSum%2==0){
                cnt = (cnt+odd)%mod;
                even++;
            }else{
                cnt = (cnt+even)%mod;
                odd++;
            }
        }
        return cnt;
    }
}