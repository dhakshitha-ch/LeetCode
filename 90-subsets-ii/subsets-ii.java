class Solution {
static void backtrack(int index, int [] nums, List<Integer> path ,List<List<Integer>> ans )
{
  
        ans.add(new ArrayList<>(path));
    
    for (int i = index; i < nums.length; i++) {

    if (i > index && nums[i] == nums[i - 1]) {
        continue;
    }

    path.add(nums[i]);
    backtrack(i+1,nums, path,ans);
    path.remove(path.size() -1);
   
    }
}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> ans= new   ArrayList<>();
        List<Integer> path= new   ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,nums, path,ans);
        return ans;
    }
}