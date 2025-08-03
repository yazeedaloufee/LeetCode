class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, c - 1, atlantic, heights);
        }

        for (int j = 0; j < c; j++) {
            dfs(0, j, pacific, heights);
            dfs(r - 1, j, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (isValid(newR, newC, visited) && heights[newR][newC] >= heights[r][c]) {
                dfs(newR, newC, visited, heights);
            }
        }
    }

    public boolean isValid(int r, int c, boolean[][] visited) {
        return r >= 0 && c >= 0 && r < visited.length && c < visited[0].length && !visited[r][c];
    }
}
