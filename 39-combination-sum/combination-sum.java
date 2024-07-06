class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        helper(output, candidates, target,0, 0, new ArrayList<Integer>() );
        return output;
    }

    void helper(List<List<Integer>> output, int[] candidates, int target, int index, int sum, List<Integer>curr){
        if (sum > target) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            if(sum + candidates[i] == target) {
                output.add(new ArrayList<>(curr));
            }else {
                helper(output, candidates, target, i, sum + candidates[i], curr);
            }

            curr.remove(curr.size() -1);

        }
    }
}