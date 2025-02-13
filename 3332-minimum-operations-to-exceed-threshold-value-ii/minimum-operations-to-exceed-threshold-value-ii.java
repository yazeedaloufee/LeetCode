class Solution {
    public int minOperations(int[] nums, int k) {
        int counter = 0; 

        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int i : nums) {
            q.add((long)i);
        }

        while(q.size() >= 2 && q.peek() <k) {
            counter++;
            Long curr = q.poll()*2 + q.poll();
            q.add(curr);

        }
        if (q.peek() < k) {
            return -1;
        }
        return counter;
    }
}