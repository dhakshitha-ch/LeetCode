class Solution {
    static void backtrack(int[] candidates, int target, List<List<Integer>> ans,List<Integer> path, int index)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || index== candidates.length)
        {
            return;
        }
        // path to add once 
        path.add(candidates[index]);
        // path to multiple 
        backtrack(candidates, target-candidates[index],ans,path,index);
        // undo 
        path.remove(path.size()-1);
        // dont add
        backtrack(candidates,target,ans,path,index+1);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target,ans,path, 0);
        return ans;
        
    }
}
