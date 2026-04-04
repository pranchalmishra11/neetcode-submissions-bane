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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        
        int mx = root.val;
        traverse(root,mx);
        return count; 
    }

    private void traverse(TreeNode root, int mx){
        if(root==null)
            return;

        mx = Math.max(root.val,mx);
        if(root.val>=mx){
            count++;
        }
        traverse(root.left,mx);
        traverse(root.right,mx);
    }
}
