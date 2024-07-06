class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, output, 0, new ArrayList<Integer>());
        return output;
        
    }

    public void helper (int[] nums, List<List<Integer>> output, int index, List<Integer> curr) {
        output.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, output, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}