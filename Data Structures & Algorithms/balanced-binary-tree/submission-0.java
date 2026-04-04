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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return helper(root);
    }

    private boolean helper(TreeNode root){
        if(root==null){
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        
        return helper(root.left) && helper(root.right);
    }

    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));

    }
}
