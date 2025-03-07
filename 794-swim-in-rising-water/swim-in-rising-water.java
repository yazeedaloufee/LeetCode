import java.util.PriorityQueue;

class Solution {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];

            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];

                if (newR >= 0 && newC >= 0 && newR < n && newC < n && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    pq.offer(new int[]{newR, newC, Math.max(time, grid[newR][newC])});
                }
            }
        }

        return -1; // This should never happen if the grid is valid.
    }
}