class Solution {

    static void combsum(int[] candidates, int target,List<List<Integer>> combination , List<Integer> path,int i)
    {   
        if(target==0 )
        {
             combination.add(new ArrayList<>(path));
             return;
        }
        if (target <0 ||  i == candidates.length)
        {
            return;
        }
        

        /// TAKE
        path.add(candidates[i]);

        // Take the same candidate again
        combsum(candidates, target - candidates[i],
                combination, path, i);

        // UNDO
        path.remove(path.size() - 1);

        // SKIP
        combsum(candidates, target,
                combination, path, i + 1);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        combsum(candidates , target , combination, path,0);
        return combination;
    }
}