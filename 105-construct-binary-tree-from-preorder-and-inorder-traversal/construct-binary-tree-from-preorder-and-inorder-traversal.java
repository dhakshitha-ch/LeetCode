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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      Map<Integer ,Integer > map= new HashMap<>();
      for(int i=0;i<inorder.length;i++)
      {
        map.put(inorder[i],i);
      } 
      preIndex=0;

      return build(preorder , 0, inorder.length-1,map); 
    }
    private TreeNode build(
        int[] preorder, int left,int right,Map<Integer,Integer> map
    )
    {
        if(left > right)
        {
            return null;
        }
        int value = preorder[preIndex++];
        TreeNode root = new TreeNode(value);

        int mid= map.get(value);
        root .left = build(preorder,left,mid-1,map);
        root.right= build(preorder,mid+1,right,map);

        return root;
    }
}