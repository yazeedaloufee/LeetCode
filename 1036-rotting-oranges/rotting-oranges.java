class Solution {
    Deque<int[]> q = new ArrayDeque<>();
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;

    public int orangesRotting(int[][] grid) {
     visited = new boolean[grid.length][grid[0].length] ;
        int total = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                q.add(new int[]{i,j});
                }   
                if(grid[i][j] == 2 ||grid[i][j] == 1)total++;
            }
        }
        if(total == 0) return 0;

        int iterations = -1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] current = q.poll();
                bfs(current, grid);
            }

            iterations++;
        }
                for(int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) return -1;
                
            }
        }


        return iterations;
    }

    private void bfs(int[] curr, int[][] grid) {
        for(int i = 0; i < 4; i++) {
            int newR = curr[0] + directions[i][0];
            int newC = curr[1] + directions[i][1];
            if(isValid(newR, newC, grid)){

                visited[newR][newC] = true;
            grid[newR][newC] = 2;

                q.add(new int[]{newR, newC});
            }
        }
    }

    private boolean isValid(int r, int c,int[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1|| visited[r][c]) return false;
        return true;
    }

}