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
    int pre_index=0;
     Map<Integer,Integer> indices = new HashMap<>();// map to store val v index for inorder list search after root
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;// if either of array not available null tree is formed
        for(int i=0;i<preorder.length;i++){
            indices.put(inorder[i],i);// split to be chosen from inorder list
        }

        return dfs(preorder, 0,preorder.length-1); // recursively constructing tree using preorder list on left sub tree and right sub tree        
    }

    private TreeNode dfs(int preorder[], int lhs, int rhs){
        if(lhs>rhs){// base case for TreeNode preparation 
            return null;
        }

        int val = preorder[pre_index++];// get the next value of root from preorder list
        TreeNode rootNode = new TreeNode(val); // make treeNode
        int split = indices.get(val); //identify split index from map using val
        rootNode.left = dfs(preorder,lhs, split-1);// construct left subtree via recursion passing left till split-1
        rootNode.right = dfs(preorder,split+1,rhs);// construct right subtree via recusrion passing split+1 till right
        return rootNode;

    }
}
