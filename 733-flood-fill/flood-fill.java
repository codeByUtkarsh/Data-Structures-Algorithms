class Solution {
    public void helper(int[][] image,int sr,int sc,int color,boolean[][] vis,int orgCol){
        if(sr<0 || sc<0  || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=orgCol){
            return;
        }

        image[sr][sc]=color;
        vis[sr][sc]=true;
        
        //left
        helper(image,sr-1,sc,color,vis,orgCol);

        //right
        helper(image,sr+1,sc,color,vis,orgCol);

        //up
        helper(image,sr,sc-1,color,vis,orgCol);

        //right
        helper(image,sr,sc+1,color,vis,orgCol);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }
}