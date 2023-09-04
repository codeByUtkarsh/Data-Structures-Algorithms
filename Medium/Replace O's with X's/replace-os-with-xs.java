//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int j,int k,int vis[][],char a[][],int delrow[],int delCol[]){
        vis[j][k]=1;
        int n = a.length;
        int m = a[0].length;
        for(int i=0;i<4;i++){
            int row = j + delrow[i];
            int col = k + delCol[i];
            if(row >= 0 && row < n && col >=0 && col<m && a[row][col] == 'O' && vis[row][col] ==0 ){
                dfs(row,col,vis,a,delrow,delCol);
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int delrow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};
        int vis[][] = new int[n][m];
        
        //Traverse the first row and col
        
        for(int j=0;j<m;j++){
            if(vis[0][j]== 0 && a[0][j]=='O'){
                dfs(0,j,vis,a,delrow,delCol);
            }
            
            if(vis[n-1][j] == 0 && a[n-1][j]=='O'){
                dfs(n-1,j,vis,a,delrow,delCol);
            }
        }
        
        for(int i=0;i<n;i++){
            
            if(vis[i][0]==0 && a[i][0]=='O'){
                dfs(i,0,vis,a,delrow,delCol);
            }
            
             if(vis[i][m-1]==0 && a[i][m-1]=='O'){
                dfs(i,m-1,vis,a,delrow,delCol);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && a[i][j]=='O'){
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}