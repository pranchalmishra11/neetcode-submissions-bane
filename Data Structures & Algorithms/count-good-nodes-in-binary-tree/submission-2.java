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
        if(root==null){
            return 0;
        }
        int mx = root.val;
        helper(root,mx);
        return count;     
    }

    private void helper(TreeNode root, int mx){
        if(root==null){
            return;
        }

        if(root.val>=mx){
            mx = Math.max(root.val,mx);
            count++;
        }

        helper(root.left,mx);
        helper(root.right,mx);
    }
}
