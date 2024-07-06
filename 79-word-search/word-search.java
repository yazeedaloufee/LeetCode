class Solution {
    char[][] board;
    int rows;
    int cols;
    int[][] visited;
    int[][] directions;
    char[] word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        visited = new int[rows][cols];
        directions = new int[][]{{0, 1}, {1, 0},{0, -1},{-1, 0}};
        this.word = word.toCharArray();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(findWord(i, j, 0)) return true;
            }
        }
        return false;
    }


    private boolean findWord(int x, int y, int index){

        if(board[x][y] != word[index]) return false;
        if(index == word.length -1 && board[x][y] == word[index])return true;
        visited[x][y] = 1;

        for (int[] direction : directions) {
            int newx = x + direction[0];
            int newy = y + direction[1];
            if(isValid(newx, newy)){
                if (findWord(newx, newy, index+1)) return true;
            }
        }
        visited[x][y] = 0;
        return false;
    }


    private boolean isValid(int x, int y) {
        if(x < 0 || x >= rows || y <0 || y >= cols || visited[x][y] == 1){
            return false;
        }
        return true;
    }
}