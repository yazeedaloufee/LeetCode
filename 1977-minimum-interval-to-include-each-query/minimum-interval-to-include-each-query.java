class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
       int[] copy = new int[queries.length];
       for(int i = 0; i < queries.length; i++) {
        copy[i] = queries[i];
       }

       Map<Integer, Integer>  hm = new HashMap<>();
       int[] output= new int[queries.length];
       Arrays.sort(queries);
       Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


       int i = 0; 
       int j = 0;
       while(i < queries.length){
            if(hm.containsKey(queries[i])){
                i++;
                continue;
            }
            while(j < intervals.length && queries[i] > intervals[j][1]) j++;
            while(j < intervals.length && queries[i] >= intervals[j][0]){
                pq.add(intervals[j]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < queries[i] ) {
                pq.poll();
            }
            hm.put(queries[i], pq.isEmpty()? -1 : (pq.peek()[1]-pq.peek()[0] +1));
            i++;
       }
       for (i = 0; i < output.length; i++) {
            output[i] = hm.get(copy[i]);
       }

       return output;



        
    }
}