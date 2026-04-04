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

public class Codec {

    private List<String> res;
    public String serialize(TreeNode root) {
        res = new ArrayList<>();// take a new String list
        generateIt(root); // preorder recursion on root to serialize it
        return String.join(",",res);// join the list as one String with , as a delimiter
        
    }

    private void generateIt(TreeNode root){
        if(root==null){ // if root is null add a N to know the null part
           res.add("N");
           return;
        }
        res.add(String.valueOf(root.val));// otherwise add whatever the value is in list
        generateIt(root.left);// recurse to left
        generateIt(root.right);// recurse to right

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        int i[] = {0};
        return dfs(arr,i);
        
    }

    private TreeNode dfs(String arr[], int i[]){
        if(arr[i[0]].equalsIgnoreCase("N")){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[i[0]]));
        i[0]++;
        node.left = dfs(arr,i);
        node.right = dfs(arr,i);
        return node;
    }
}
