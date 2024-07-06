class Solution {
    List<List<Integer>> output;
    int[] nums;
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        this.nums = nums;
        used = new int[nums.length];
        helper(new ArrayList<>(), 0);
        return output;
    }

    public void helper(List<Integer> curr, int index){
        if(index == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] == 0){
            used[i] = 1;
            curr.add(nums[i]);
            helper(curr, index + 1);
            curr.remove(curr.size() - 1);
            used[i] = 0;
            }
        }
    }
}