class Solution {

    static void backtracking(int [] nums,List<List<Integer>> ans, List<Integer> path,boolean [] used)
    {
        if(path.size() == nums.length)
        {
            ans.add(new ArrayList<>(path));
             return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
                 }
           if(used[i] == true)
           {
            continue;
           }
            path.add(nums[i]);
        used[i] = true;

        backtracking(nums,ans,path,used);

               used[i] = false;
              path.remove(path.size() - 1);

        }


    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
          boolean [] used= new boolean[nums.length];
         Arrays.sort(nums);
        backtracking(nums,ans,path,used);
        return ans;
        
    }
}