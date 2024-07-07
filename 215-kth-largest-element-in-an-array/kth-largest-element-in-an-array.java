class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums) {
            add(i, pq, k);
        }
        return pq.peek();
        

    }

    public void add(int i,  PriorityQueue pq , int k) {
        pq.add(i);

        if(pq.size() >k) pq.poll();

    }
}