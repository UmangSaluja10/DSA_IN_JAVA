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
    public static int[] dfs(TreeNode node){
        if(node==null)return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int take = node.val + left[1] + right[1];
        int skip = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{take,skip};
    }
    public int rob(TreeNode root) {
        int[] arr = new int[2];
        arr = dfs(root);
        return Math.max(arr[0],arr[1]);
    }
}
