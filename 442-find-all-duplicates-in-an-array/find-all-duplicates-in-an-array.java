class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicate = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                // Already visited → duplicate
                duplicate.add(Math.abs(nums[i]));
            } else {
                // Mark as visited
                nums[index] = -nums[index];
            }
        }

        return duplicate;
    }
}