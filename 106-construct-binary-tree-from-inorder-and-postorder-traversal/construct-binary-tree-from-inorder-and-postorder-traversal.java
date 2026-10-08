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
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(
        int[] postorder,
        int left,
        int right,
        Map<Integer, Integer> map
    ) {
        if (left > right) {
            return null;
        }

        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);

        int mid = map.get(value);

        // Build RIGHT first because postorder is read backward
        root.right = build(postorder, mid + 1, right, map);
        root.left = build(postorder, left, mid - 1, map);

        return root;
    }
}