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
    class info{
        boolean isBST;
        int s;
        int min;
        int max;
        info(boolean isBST,int s, int min,int max){
            this.isBST = isBST;
            this.s = s;
            this.min = min;
            this.max = max;
        }
    }
    int maxSum =0;
    public info largestSumBST(TreeNode root){
        if(root == null){
            return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        info leftInfo = largestSumBST(root.left);
        info  rightInfo = largestSumBST(root.right);
        int sum = leftInfo.s + rightInfo.s+ root.val;
        int min = Math.min(root.val, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.val, Math.max(leftInfo.max,rightInfo.max));

        if(root.val <= leftInfo.max || root.val >= rightInfo.min){
            return new info(false,sum,min,max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxSum = Math.max(maxSum,sum);
            return new info(true,sum,min,max);
        }
        return new info(false,sum,min,max);
    }
    public int maxSumBST(TreeNode root) {
        largestSumBST(root);
        return maxSum;
    }
}