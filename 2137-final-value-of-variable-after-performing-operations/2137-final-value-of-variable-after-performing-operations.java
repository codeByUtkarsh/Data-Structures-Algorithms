class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int counter =0;
        for(String st:operations){
            if(st.contains("+")){
                counter+=1;
            }else{
                counter-=1;
            }
        }
        return counter;
    }
}