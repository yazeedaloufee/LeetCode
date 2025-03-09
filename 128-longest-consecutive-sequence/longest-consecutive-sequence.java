class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for(int n : nums) {
            numbers.add(n);
        }
        Set<Integer> seen = new HashSet<>();
        int output = 0;
        for (int n : nums) {
            if(!numbers.contains(n)) continue;
            int temp = 1;
            // deleted from set while we calculated
            int next = n; 
            while(numbers.contains(next+1)){
                temp++;
                numbers.remove(next+1);
                next = next+1;
            }
            next = n;
            while(numbers.contains(next-1)){
                temp++;
                numbers.remove(next-1);
                next = next-1;
            }
            output=Math.max(output,temp);
        }
        return output;
        
    }
}