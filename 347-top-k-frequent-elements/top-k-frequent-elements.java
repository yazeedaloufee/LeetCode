class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k) pq.poll();
        }

        int[] output = new int[k];

        int index = 0; 
        while(!pq.isEmpty()) {
            output[index++] = pq.poll()[0];
        }
        return output;
    }
}