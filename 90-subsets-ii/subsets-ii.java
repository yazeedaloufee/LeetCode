class Solution {
    List<List<Integer>> output;
    int[] nums;
    Set<String> track;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        output = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        track = new HashSet<>();

        helper(new ArrayList<>(), 0);
        return output;
    }

    public void helper(List<Integer> curr, int index){
        if(index > nums.length) return;
        String code = toCode(curr);
        if(!track.contains(code)){
            output.add(new ArrayList<>(curr));
            track.add(code);
        }
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            helper(curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    public String toCode (List<Integer> curr) {
        StringBuilder sb = new StringBuilder();

        for(Integer i : curr) {
            sb.append(i);
        }
        return sb.toString();
    }

}