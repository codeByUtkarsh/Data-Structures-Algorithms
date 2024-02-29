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
    public boolean helper(TreeNode root,int ts,int cs){
        if(root == null){
            return false;
        }

        cs += root.val;

        if(root.left == null && root.right == null){
            return cs == ts;
        }

        return helper(root.left,ts,cs) || helper(root.right,ts,cs);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int cs=0;
        if(root == null) return false;
        return helper(root,targetSum,cs);
    }
}