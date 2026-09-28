class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
       StringBuilder path= new StringBuilder();
        
        build(root, path , ans);

        return ans;
    }

    void build(TreeNode root, StringBuilder path, List<String> ans) {

        if(root == null)
        {
            return ;
        }
        int orginal = path.length();

        if(path.length() > 0)
        {
            path.append("->");
        }
        path.append(root.val);

        if(root.left== null && root.right== null)
        {
            ans.add(path.toString());
        }
        else
        {
            build(root.left,path,ans);
            build(root.right,path,ans);
        }

        path.setLength(orginal);
    }
}