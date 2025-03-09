class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            int[] checkC = new int[10];
            int[] checkR = new int[10];
            int[] checkSquare = new int[10];

            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    checkC[board[i][j]-'0']++;
                    if(checkC[board[i][j]-'0'] >1 ) return false;
                }
                if(board[j][i] != '.'){
                    checkR[board[j][i]-'0']++;
                    if(  checkR[board[j][i]-'0'] >1 ) return false;
                }
                char c = board[(i/3)*3+j/3][(i%3)*3 +j%3];
                if(c != '.'){
                    checkSquare[c-'0']++;
                    if( checkSquare[c-'0'] > 1) return false;
                }
            }
        }
        return true;
        // 0  0
        // 1  0
        // 2  0
        // 3  1
        // 4  1
        // 5  1
        // 6  2
        // 7  2
        // 8  2

        // 0  0
        // 1  1
        // 2  2
        // 3  0
        // 4  1
        // 5  2
        // 6  0
        // 7  1
        // 8  2
        
    }
}