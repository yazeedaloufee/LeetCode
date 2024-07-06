class Solution {
    List<List<Integer>> output;
    int[] nums;
    Set<Integer> track;
    public List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        this.nums = nums;
        track = new HashSet<>();
        helper(new ArrayList<>(), 0);
        return output;
        
    }

    public void helper(List<Integer> curr, int index){
        if(index == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!track.contains(nums[i])){
            track.add(nums[i]);
            curr.add(nums[i]);
            helper(curr, index + 1);
            curr.remove(curr.size() - 1);
            track.remove(nums[i]);
            }
        }
    }
}