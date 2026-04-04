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

class Solution {// path = with a split at a node(root+left+right(at the root node)) or without a split(a chosen path via max)
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;

        dfs(root); 
        return result;      
    }

    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
         
         leftMax = Math.max(leftMax,0);// avoiding -ve values in downstream
         rightMax = Math.max(rightMax,0);

         result = Math.max(result,leftMax+rightMax+root.val);// update result  = without split,  sum at that node as root+max from left=max from right
         return root.val + Math.max(leftMax,rightMax);// but return to previous or parent = with a split-: a chosen path  of max value

    }
}
