class Solution {
    public static int path(int i,int j, int m, int n, int arr[][]){
        
        if(i == m-1 && j== n-1) return 1;
        if(i>=m || j>=n) return 0;

        if(arr[i][j]!=-1) return arr[i][j];
        else return arr[i][j]=(path(i+1,j,m,n,arr)+path(i,j+1,m,n,arr));
    }
    public int uniquePaths(int m, int n) {
        int arr[][]= new int[m][n];
        for(int k=0;k<m;k++){
            for (int l=0;l<n;l++) {
                arr[k][l]=-1;
            }
        }
        int p = path(0,0,m,n,arr);
        return p;
    }
}