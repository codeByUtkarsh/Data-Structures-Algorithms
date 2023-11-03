//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static Boolean targetSubsetSum(int arr[],int sum){
        int n= arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        //Check Condition
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //valid
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }
        return dp[n][sum];
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return targetSubsetSum(arr,sum);
        
    }
}