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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalAns = new ArrayList<>();
        if(root==null){
            return finalAns;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
             List<Integer> templist = new ArrayList<>();
             int curr_size=q.size();
            for(int i=1;i<=curr_size;i++){
                TreeNode t = q.poll();
                templist.add(t.val);
                if(null!=t.left){
                    q.add(t.left);
                }

                if(null!=t.right){
                    q.add(t.right);
                }
            }
            finalAns.add(templist);
        
        }

        return finalAns;
        
    }
}
