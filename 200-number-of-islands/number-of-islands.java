class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        visited = new boolean[r][c];
        int counter = 0;
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid);
                    counter++;
                }
            }
        }
        return counter;
        
    }

    public void dfs (int r, int c, char[][] grid) {
        if (!(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length) || visited[r][c] || grid[r][c] == '0') return;
        visited[r][c] = true;

        
        dfs(r + 1, c,grid);
        dfs(r - 1, c,grid);
        dfs(r ,c + 1,grid);
        dfs(r ,c - 1,grid);
    }
}