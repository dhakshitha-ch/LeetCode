class Solution {


    static void backtrack(int k,int n, List<List<Integer>> ans,List<Integer> path,int idx)
    {

      if(n==0 && k ==0 )
        {
            ans.add(new ArrayList<>(path));
             return;
        }
        if (n<0 || k < 0 )
        {
            return;
        }
for (int i= idx; i <= 9; i++) {

      
        if(i> n)
        {
            break;
        }
    path.add(i);
     backtrack(k - 1, n - i,  ans,path ,i+1);
     path.remove(path.size()-1);
}

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans= new ArrayList<>();
    List<Integer> path = new ArrayList<>();
     
     backtrack(k,n,ans,path,1);
     return ans;


    }
}