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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.add(root);
        boolean flag= true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<Integer>(size);
            for(int i=0;i<size;i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                if(flag==true) temp.add(q.poll().val);
                else temp.add(0,q.poll().val);
            }
            flag = !flag;
            list.add(temp);
        }
        return list;
    }
}