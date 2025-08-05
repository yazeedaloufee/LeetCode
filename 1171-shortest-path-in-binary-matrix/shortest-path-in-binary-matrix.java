class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = new int[][]{{1,1}, {-1, 1}, {-1,-1}, {1,-1}, {-1,0}, {1,0}, {0,1}, {0,-1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        
        int length = 0; 

        while(!q.isEmpty()) {
            length++;
            int size = q.size();
            int i =0; 
            while(i < size) {
                int[] current = q.poll();
                if(current[0] == grid.length-1 && current[1] == grid[0].length -1) {
                    return length;
                }
                for(int[] direction : directions) {
                    int newR = direction[0] + current[0];
                    int newC = direction[1] + current[1];
                    if(isValid(newR, newC, grid, visited)) {
                        visited[newR][newC] = true;
                        q.offer(new int[]{newR, newC});
                    }
                }

                i++;
            }
        }

        return -1;
        
    }

    private boolean isValid(int r, int c, int[][] grid, boolean[][] visited) {
        return r >=0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] == 0; 
    }
}