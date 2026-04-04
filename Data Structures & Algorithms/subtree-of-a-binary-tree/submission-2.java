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
        if(subRoot==null){
            return true;
        }

        if(root==null){
            return false;
        }

        if(isIdentical(root,subRoot)){
            return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isIdentical(TreeNode mroot, TreeNode subRoot){
        if(mroot==null && subRoot==null){
            return true;
        }
        else if((mroot!=null && subRoot==null) || (mroot==null && subRoot!=null)){
            return false;
        }
        else{
            if(mroot.val!=subRoot.val){
                return false;
            }
        }

        return isIdentical(mroot.left,subRoot.left) && isIdentical(mroot.right,subRoot.right);

    }
}
