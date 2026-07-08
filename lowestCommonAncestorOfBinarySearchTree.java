/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode find(TreeNode node, TreeNode p, TreeNode q){
        if(node==null)return null;
        if(p.val<node.val && q.val<node.val){
            return find(node.left,p,q);
        }else if(p.val>node.val && q.val>node.val){
            return find(node.right,p,q);
        }else{
            return node;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root,p,q);
    }
}