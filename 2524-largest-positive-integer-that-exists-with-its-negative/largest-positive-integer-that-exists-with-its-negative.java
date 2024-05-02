class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int max = -1; 
        for(int n : nums) {
            if(n > max && set.contains(-n)) {
                max = n;
            }
        }

        return max;
        
    }
}