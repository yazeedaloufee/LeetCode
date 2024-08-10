class Solution {
    public int regionsBySlashes(String[] grid) {
        int length = grid.length * 3;

        char[][] output = new char[length][length];
        boolean[][] visited = new boolean[length][length];

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length(); j++) {

                char c = grid[i].charAt(j);
                if (c == '/') {
                    blockAntiDiagonal(output, i * 3, j * 3);
                } else if (c == '\\') {
                    blockDiagonal(output, i * 3, j * 3);
                }
            }

        }
        int result = 0;

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                if (dfs(visited, output, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean dfs(boolean[][] visited, char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||visited[r][c] || grid[r][c] == '*'){
            return false;
        }

        visited[r][c] = true;
        dfs(visited, grid, r + 1, c);
        dfs(visited, grid, r, c + 1);
        dfs(visited, grid, r - 1, c);
        dfs(visited, grid, r, c - 1);
        return true;

    }

    private void blockDiagonal(char[][] grid, int r, int c) {
        for (int i = 0; i < 3; i++) {
            grid[r + i][c + i] = '*';
        }
    }

    private void blockAntiDiagonal(char[][] grid, int r, int c) {
        // System.out.println( "grid length" + grid.length);
        // System.out.println("grid[0] length" + grid[0].length);
        // System.out.println(r + " " + c);

        for (int i = 0; i < 3; i++) {
            grid[r + i][c + 2 - i] = '*';
        }
    }
}