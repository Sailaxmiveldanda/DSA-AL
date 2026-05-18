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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int lh = dfs(node.left);
        int rh = dfs(node.right);
        diameter = Math.max(diameter, lh+rh);
        return 1 + Math.max(lh,rh);
    }
}