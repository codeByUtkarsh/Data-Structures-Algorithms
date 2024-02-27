/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Info{
        int diam;
        int height;

        public Info(int diam , int height){
            this.diam = diam;
            this.height = height;
        }
    }

    public static Info diameter(TreeNode root){
        if(root == null){
            return new Info(0,0);
        }

        Info lInfo = diameter(root.left);
        Info rInfo = diameter(root.right);

        int diam = Math.max(Math.max(lInfo.diam,rInfo.diam),lInfo.height+rInfo.height);
        int height = Math.max(lInfo.height,rInfo.height)+1;

        return new Info(diam,height);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).diam;
    }
}