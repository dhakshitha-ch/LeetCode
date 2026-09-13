class Solution {

    static void backtrack(int[] candidates, int target,List<List<Integer>> ans,List<Integer> path ,int index)
    {

      if(target ==0)
      {
        ans.add(new ArrayList<>(path));
        return;
      }
      if(target<0 || index== candidates.length)
      {
        return;
      }

      for(int i=index;i<candidates.length;i++)
      {

        if(i> index && candidates[i] == candidates[i-1])
        {
            continue;
        }
        if(candidates[i] > target)
        {
            break;
        }
        path.add(candidates[i]);
        backtrack(candidates, target-candidates[i] , ans, path,i+1);
        path.remove(path.size()-1);
      }
    }    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
          Arrays.sort(candidates);
         backtrack(candidates, target , ans, path,0);
         return ans;
    }
}