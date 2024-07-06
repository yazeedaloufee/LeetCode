class Solution {
    int target;
    int[] cand;
    List<List<Integer>> output;
    int[] track;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        cand = candidates;
        Arrays.sort(cand);
        output = new ArrayList<>();
        track = new int[cand.length];
        helper(new ArrayList<>(), 0, 0);
        return output;
    }

    public void helper(List<Integer> curr, int sum, int index) {
        if(sum == target) output.add(new ArrayList<>(curr));
        if(sum > target) return;

        for (int i = index; i < cand.length; i++) {
            if(i > index && cand[i] == cand[i - 1])continue;
            if(cand[i] > target) break;
            curr.add(cand[i]);
            helper(curr, sum + cand[i],i +1);
            curr.remove(curr.size() -1);
        }
    }
}