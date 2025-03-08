class Solution {
    int output = Integer.MAX_VALUE;
    int maxStops;
    Map<Integer, List<int[]>> hm;
    int dst;
    int[][] memo; // Memoization table

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        maxStops = k;
        this.dst = dst;
        hm = new HashMap<>();
        memo = new int[n][k + 2]; // Initialize memoization table
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Mark all entries as uncomputed
        }

        // Create adjacency list
        for (int[] flight : flights) {
            hm.computeIfAbsent(flight[0], (x) -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        dfs(src, 0, 0);
        return output == Integer.MAX_VALUE ? -1 : output;
    }

    private void dfs(int src, int cost, int stops) {
        // If destination is reached, update the best cost
        if (src == dst) {
            output = Math.min(output, cost);
            return;
        }

        // If no more stops are allowed, return
        if (stops > maxStops) return;

        // If the result for this city and stops is already computed, return
        if (memo[src][stops] != -1 && memo[src][stops] <= cost) return;

        // Update memoization
        memo[src][stops] = cost;

        // Explore all neighbors
        List<int[]> nexts = hm.get(src);
        if (nexts != null) {
            for (int[] next : nexts) {
                // Prune if the current cost exceeds the best known cost
                if (cost + next[1] < output) {
                    dfs(next[0], cost + next[1], stops + 1);
                }
            }
        }
    }
}