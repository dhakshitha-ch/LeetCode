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
 // Apparently maxpath= diameter and just return its sum rayher than height
class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return sum;
    }
  public int maxsum(TreeNode root)
  {

     if( root== null)
     {
        return 0;
     }

     int left= Math.max(0,maxsum(root.left));
     int right= Math.max(0,maxsum(root.right));

            sum = Math.max(sum, left + root.val + right);


    return root.val + Math.max(left,right);
  }

}