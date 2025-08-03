class Solution {
    int[][] directions= new int[][]{{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int max = 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid, visited));
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visited){
        visited[r][c] = true;
        int space = 0;
        for(int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if(isValid(newR, newC, grid, visited)) {
                space+=dfs(newR, newC, grid, visited);
            }
        }
        return space + 1;

    }

    private boolean isValid(int r, int c, int[][] grid, boolean[][] visited ) {
        return r >= 0 && c >= 0 && r <grid.length && c < grid[0].length && !visited[r][c] && grid[r][c] == 1;
    }
}