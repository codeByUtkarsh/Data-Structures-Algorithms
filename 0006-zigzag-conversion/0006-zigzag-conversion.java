class Solution {
    public String convert(String s, int numRows) {
        int n = numRows;
        String[] st = new String[n];
        for(int i=0;i<n;i++){
            st[i]="";
        }
        int j=0;
        while(j<s.length()){
            for(int i=0;i<n && j<s.length();i++){
                st[i]+=s.charAt(j++);
            }
            for(int i=n-2;i>0  && j<s.length() ;i--){
                st[i]+=s.charAt(j++);
            }
        }
        String ans = "";
        for(int i=0;i<st.length;i++){
            ans+=st[i];
        }
        return ans;
    }
}