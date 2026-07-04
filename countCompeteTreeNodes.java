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
    public static int lh(TreeNode node){
        if(node == null)return 0;
        int height = 1;
        while(node.left!=null){
            height++;
            node=node.left;
        }
        return height;
    }
    public static int rh(TreeNode node){
        if(node == null)return 0;
        int height = 1;
        while(node.right!=null){
            height++;
            node=node.right;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int leftHeight = lh(root);
        int rightHeight = rh(root);
        if(leftHeight==rightHeight)return (((int)Math.pow(2,leftHeight))-1);
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
}