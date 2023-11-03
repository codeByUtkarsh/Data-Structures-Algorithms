//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapsackUtil(int[] val,int[] wt,int n,int W,int[][] dp){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        
        if(wt[n-1]<=W){ //Valid
            //include
            int ans1 = val[n-1]+knapsackUtil(val,wt,n-1,W-wt[n-1],dp);
            
            //exclude
            int ans2 = knapsackUtil(val,wt,n-1,W,dp);
            
            dp[n][W] = Math.max(ans1,ans2);
        }else{ //invalid
            dp[n][W] = knapsackUtil(val,wt,n-1,W,dp);
            return dp[n][W];
        }
        return dp[n][W];
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[n+1][W+1];
         for(int i=0;i<dp.length;i++){
             for(int j=0;j<dp[0].length;j++){
                 dp[i][j]=-1;
             }
         }
         return knapsackUtil(val,wt,n,W,dp);
    } 
}


