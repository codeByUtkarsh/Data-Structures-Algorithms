class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt =0;
        for(int hr:hours){
            if(hr>=target) cnt++;
        }
        return cnt;
    }
}