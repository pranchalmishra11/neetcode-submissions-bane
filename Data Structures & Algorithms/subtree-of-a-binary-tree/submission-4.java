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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null && root!=null){
            return true;
        }

        if(subRoot!=null && root==null){
            return false;
        }

        if(checkSame(root,subRoot)){
            return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    private boolean checkSame(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }

        if((p!=null && q==null) || (p==null && q!=null)){
            return false;
        }

        if(p.val!=q.val){
            return false;
        }

        return checkSame(p.left,q.left) && checkSame(p.right,q.right);
    }
}
