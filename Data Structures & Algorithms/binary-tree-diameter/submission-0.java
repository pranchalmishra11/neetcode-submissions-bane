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
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        helper(root);
        return result;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        result = Math.max(result,left+right);
        return 1+Math.max(left,right);
    }
}
