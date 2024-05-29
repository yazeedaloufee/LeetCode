class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    char[][] grid;
    int[][] visited;
    int count = 0; 
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int r = grid.length;
        int c = grid[0].length;
        visited = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1' && visited[i][j] != 1){

                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int r, int  c) {
        if(visited[r][c] == 1) {
            return;
        }
        visited[r][c] = 1;
        
        for (int[] direction : directions) {
            int newC = direction[0] + c;
            int newR = direction[1] + r;
            
            if(isValid(newC, newR) ){
                dfs(newR, newC);
            }
        }
    }
    
    private boolean isValid(int x, int y) {
        
        if(x < 0 || y < 0 || y >= grid.length || x >= grid[0].length || visited[y][x] == 1 || grid[y][x] == '0' ){
            return false;
        }
        return true;
    }
    
    
}