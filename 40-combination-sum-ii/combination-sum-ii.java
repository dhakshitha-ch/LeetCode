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


         for (int j= i; j < candidates.length; j++) {

       if (j > i && candidates[j] == candidates[j- 1]){
        continue;
         }
         if (candidates[j] > target)
                break;
        path.add(candidates[j]);
        // SKIP
        combsum(candidates, target-candidates[j],
                combination, path, j + 1);
        
        // UNDO
        path.remove(path.size() - 1);

         }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
       Arrays.sort(candidates);
        combsum(candidates , target , combination, path,0);
        return combination;
    }
}