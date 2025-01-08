class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count=1;
        StringBuilder temp = new StringBuilder(a);
        while(temp.length()<b.length()){
            temp.append(a);
            count++;
        }  
        if(temp.toString().contains(b)) return count;
        if(temp.append(a).toString().contains(b)) return count+1;
        return -1;
    }
}