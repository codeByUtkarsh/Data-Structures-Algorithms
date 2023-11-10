//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code 
        int num=1;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<S.length();i++){
            st.push(num++);
            if(S.charAt(i)=='I'){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }
        st.push(num);
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
}
