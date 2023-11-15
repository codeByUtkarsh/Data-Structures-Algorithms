//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        int res1 = distinctSub(str1);
        int res2 = distinctSub(str2);
        
        if(res1>=res2) return str1;
        return str2;
    }
    public static int distinctSub(String str){
        int n = str.length();
        int arr[] = new int[26];
        Arrays.fill(arr,-1);
        
        int ans=0;
        int diff=0;
        
        for(int i=0;i<str.length();i++){
            int x = str.charAt(i)-'a';
            if(i==0){
                ans =1;
                arr[x]=1;
                continue;
            }
            
            diff = 1+ ans;
            if(arr[x]==-1) ans = ans+diff;
            else ans = ans+diff-arr[x];
            arr[x]=diff;

        }
        return ans+=1;
    }
}