//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int count=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character> st = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(st.contains(s.charAt(j))){
                    break;
                }
                st.add(s.charAt(j));
            }
            count = Math.max(st.size(),count);
        }
        return count;
    }
}