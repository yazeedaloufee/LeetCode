class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] result = new int[2];
        Arrays.sort(arr);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
    double valueA = (double)a[0] / a[1];
    double valueB = (double)b[0] / b[1];
    return Double.compare(valueB, valueA); 
});

        for(int i = 0; i < arr.length; i++ ) {
            for(int j = i +1; j < arr.length; j++) {
                int[] temp = new int[]{arr[i], arr[j]};
                  pq.add(temp);
                
                if(pq.size() > k ) {
                    pq.poll();
                }
            }

        }
        result = pq.peek();

        // while(!pq.isEmpty()) {
        //     result = pq.poll();
        //     System.out.println(Arrays.toString(result));
        // }
        return result;




        
    }
}