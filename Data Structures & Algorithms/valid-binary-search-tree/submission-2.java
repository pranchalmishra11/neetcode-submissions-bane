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
    List<Integer> ans = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=1;i<ans.size();i++){
            if(ans.get(i)<=ans.get(i-1)){
                return false;
            }
        }

        return true;
        
    }

    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}
