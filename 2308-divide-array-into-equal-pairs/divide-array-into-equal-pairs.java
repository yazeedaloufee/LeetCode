class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n : nums) {
            hm.put(n, hm.getOrDefault(n,0) + 1);
        }
        for (int n : hm.values()) {
            if(n % 2 != 0) return false;
        }
        return true;
        
    }
}