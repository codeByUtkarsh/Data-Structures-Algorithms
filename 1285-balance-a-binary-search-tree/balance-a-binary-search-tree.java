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
    public void inorderT(TreeNode root,ArrayList<Integer> a){

        if(root == null){
            return;
        }
        inorderT(root.left,a);
        a.add(root.val);
        inorderT(root.right,a);

    }
    public TreeNode createBST(ArrayList<Integer> a,int s,int e){
        if(s>e){
            return null;
        }

        int mid = (s+e)/2;
        TreeNode root = new TreeNode(a.get(mid));
        root.left = createBST(a,s,mid-1);
        root.right = createBST(a,mid+1,e);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderT(root,inorder);
        
        int s=0;
        int e = inorder.size()-1;
        return createBST(inorder,s,e);
    }
}