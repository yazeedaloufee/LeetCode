class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0; 
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(i, j, grid, visited)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0' || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        dfs(i  , j - 1 , grid, visited);
        dfs(i , j + 1 , grid, visited);
        dfs(i - 1 , j , grid, visited);
        dfs(i + 1 , j  , grid, visited);
        return true;
    }
}