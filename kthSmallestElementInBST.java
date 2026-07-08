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
    int count;
    int answer;
    public void find(TreeNode node, int k){
        if(node==null || count==k){
            return;
        }else{
            find(node.left,k);
            count++;
            if(count==k){ 
                answer = node.val;
                return;
            }
            find(node.right,k);
        }
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        find(root,k);
        return answer;
    }
}