class Solution {
    boolean[][] visited;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for (int j = 0; j < visited[0].length; j++) {
            dfs(0, j);
            dfs(board.length -1, j);
        }
        for (int i = 0; i < visited.length; i++) {
            dfs(i, 0);
            dfs(i, visited[0].length -1);
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

        
    }

    private void dfs(int r, int c) {
        if (!isValid(r, c))
            return;
        if (board[r][c] == 'X')
            return;
        visited[r][c] = true;
        dfs(r - 1, c);
        dfs(r, c - 1);
        dfs(r + 1, c);
        dfs(r, c + 1);

    }

    private boolean isValid(int r, int c) {
        return !(r < 0 || c < 0|| r >= visited.length|| c >= visited[0].length || visited[r][c]);
    }
}