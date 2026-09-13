class Solution {
    static void backtrack(int n, int k , List<List<Integer>> ans, 
     List<Integer> path,int index)
     {
        if(k==0) 
        {
            ans.add(new ArrayList<>(path));
             return;
        }

        for (int i= index;i<=n;i++)
        {
            
            path.add(i);
            backtrack(n, k-1,ans, path, i +1);
            path.remove(path.size()-1);

        }

     }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans= new ArrayList<>();

        List<Integer> path= new ArrayList<>();

        backtrack(n,k,ans,path,1);

        return ans;
    }
}