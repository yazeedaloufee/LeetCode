class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i : nums) {
            set.add(i);
        }
        int max = 0; 
        for(int i : nums) {
            if(set.contains(i)){
                // look left and delete
                // look right and delted
                int left = i-1;
                int right = i + 1;
                int add =1;
                while(set.contains(right)){
                    set.remove(right);
                    add++;
                    right++;
                }
                while(set.contains(left)){
                    set.remove(left);
                    add++;
                    left--;
                }
            max = Math.max(max,add);
            }
        }
        return max;
        
    }
}