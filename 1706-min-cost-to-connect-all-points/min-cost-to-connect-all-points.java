class Solution {
    public int minCostConnectPoints(int[][] points) {


        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        int connected = 0; 
        pq.offer(new int[]{0, 0});
        
        boolean[] visited = new boolean[points.length];
        int output = 0;

        while(connected < points.length) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentWeight = current[1];

            if(visited[currentNode]) continue;

            visited[currentNode] = true;
            output+=currentWeight;
            connected++;

            for(int nextPoint= 0; nextPoint < points.length; nextPoint++) {
                if(!visited[nextPoint]){
                    int nextWeight = Math.abs(points[currentNode][0] - points[nextPoint][0]) 
                    + Math.abs(points[currentNode][1] - points[nextPoint][1]);
                    pq.offer(new int[]{nextPoint, nextWeight});
                }
            }

        }
        return output;
        
    }
}