class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        build(root, "", ans);

        return ans;
    }

    void build(TreeNode root, String path, List<String> ans) {

        path = path + root.val;

        // Reached a leaf
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        // Go left
        if (root.left != null) {
            build(root.left, path + "->", ans);
        }

        // Go right
        if (root.right != null) {
            build(root.right, path + "->", ans);
        }
    }
}