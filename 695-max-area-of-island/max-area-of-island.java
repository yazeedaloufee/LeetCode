class Solution {
    int max; 
    int[][] grid;
    int[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        max = 0; 
        this.grid = grid;
        visited = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(dfs(i, j), max);
            }
        }
        return max;
    }
    public int dfs(int x, int y) {
        if(x < 0 || y < 0 ||x >= grid.length|| y >= grid[0].length || grid[x][y] == 0 || visited[x][y] == 1) return 0; 
        visited[x][y] = 1;
        int inMax = 1; 
        inMax +=  dfs(x+1, y);
        inMax +=  dfs(x-1, y);
        inMax +=  dfs(x, y-1);
        inMax +=  dfs(x, y+1);
        return inMax;
    }
}