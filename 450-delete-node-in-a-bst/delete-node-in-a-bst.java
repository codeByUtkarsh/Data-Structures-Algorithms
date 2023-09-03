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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else{

            //case 1--> leaf Node
            if(root.left == null && root.right == null){
                return null;
            }

            //Case 2 --> Single Child

            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{

                //Case 3 --> when there are two children

                TreeNode IS = findInorderSuccessor(root.right);
                root.val = IS.val;
                root.right = deleteNode(root.right,IS.val);
            }

        }
        return root;
    }
    public static TreeNode findInorderSuccessor(TreeNode root){
        while(root.left!= null){
            root = root.left;
        }
        return root;
    }
}