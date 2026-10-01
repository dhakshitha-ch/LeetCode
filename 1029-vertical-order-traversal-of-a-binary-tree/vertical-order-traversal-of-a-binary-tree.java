class Solution {

    static class Pair{
        int row,col,val;

        public Pair(int row,int col,int val){
           this.row=row;
           this.col=col;
           this.val=val;
        }
    }

    List<Pair> pairs;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        pairs=new ArrayList<>();
        dfs(root,0,0);

        Collections.sort(pairs,(a,b)->{
            if(a.col!=b.col) return Integer.compare(a.col,b.col);
            if(a.row!=b.row) return Integer.compare(a.row,b.row);

            return Integer.compare(a.val,b.val);
        });

        int previous=Integer.MIN_VALUE;
        int size=-1;
        List<List<Integer>> ans=new ArrayList<>();
        
        for(Pair pair:pairs){
            if(pair.col!=previous){
                ans.add(new ArrayList<>());
                size++;
                previous=pair.col;
            }

            ans.get(size).add(pair.val);
        }
       
        return ans;
    }
    private void dfs(TreeNode root,int row,int col){
        if(root==null) return;

        pairs.add(new Pair(row,col,root.val));

        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);
    }
}