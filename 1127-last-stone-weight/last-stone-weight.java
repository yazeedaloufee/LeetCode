class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i : stones) {
            pq.add(i);
        }
        while(pq.size() > 1) {
            int temp = Math.abs(pq.poll() - pq.poll()); 
            if(temp > 0) {
                pq.add(temp);
            }
        }
        return pq.isEmpty() ? 0: pq.peek();
    }
}