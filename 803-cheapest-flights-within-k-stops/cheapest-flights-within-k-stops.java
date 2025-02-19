class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // build adjacency list
        Map<Integer, List<int[]>> hm = new HashMap<>();

        for(int[] flight : flights) {
            List<int[]> stop = hm.computeIfAbsent(flight[0], (Integer x)-> new ArrayList<int[]>());
            stop.add(flight);
            hm.put(flight[0], stop);
        }
        Map<Integer, Integer> seen = new HashMap();
        for(int i = 0; i < 100; i++) {
            seen.put(i, Integer.MAX_VALUE);
        }

        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{src, 0});
        
        System.out.println(hm);
        int output = Integer.MAX_VALUE;
        //bfs / eaiser for the number of stops
        int s = k + 1;
        while(!q.isEmpty() && s >= 0) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                int[] current = q.poll();
                int currentStop = current[0];
                int currentCost = current[1];
                
                if(currentStop == dst) {
                    output = Math.min(output, currentCost);
                }

                
                if(currentCost > output || currentCost >= seen.get(currentStop)) continue;
                seen.put(currentStop, currentCost);
                List<int[]> nextStops =  hm.get(currentStop);

                if(nextStops != null)
                for (int[] nextStop : nextStops){
                    q.add(new int[]{nextStop[1], currentCost + nextStop[2]});
                }

            }
            s--;
        }
        return output == Integer.MAX_VALUE ? -1 : output;
        
    }
}