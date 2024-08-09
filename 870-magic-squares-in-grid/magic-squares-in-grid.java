class Solution {

    int[][] grid;

    public int numMagicSquaresInside(int[][] grid) {

        this.grid = grid;

        if (grid == null || grid.length < 2 || grid[0].length < 2)
            return 0;

        int output = 0;

        for (int r = 0; r < grid.length - 2; r++) {
            for (int c = 0; c < grid[0].length - 2; c++) {
                if (isMagicSquare(r, c)) {
                    System.out.println("r = " + r + ", c = " + c);
                    output++;
                }
            }
        }
        return output;
    }

    private boolean isMagicSquare(int x, int y) {
        if(!isDistinct(x,y)) return false;

        int sum = 0;
        // check for rows;
        for (int r = x; r < x + 3; r++) {

            int tempSum = 0;

            for (int c = y; c < y + 3; c++) {
                tempSum += grid[r][c];
            }

            if (sum == 0) {
                sum = tempSum;
            } else {
                if (sum != tempSum)
                    return false;
            }
        }

        // check for cols;
        for (int c = y; c < y + 3; c++) {

            int tempSum = 0;

            for (int r = x; r < x + 3; r++) {
                tempSum += grid[r][c];
            }
            if (sum != tempSum)
                return false;
        }

        int tempSum = 0;
        // check for diagonal;
        for (int r = 0; r < 3; r++) {
            tempSum += grid[x + r][y + r];
        }

        if (sum != tempSum)
            return false;

        // check for other diagonal;
        tempSum = 0;
        for (int i = 0; i < 3; i++) {
            tempSum += grid[x + 2 - i][y + i];
        }

        if (sum != tempSum)
            return false;

        return true;
    }

    private boolean isDistinct(int x, int y) {
        Set<Integer> set = new HashSet();
        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++) {
                if(grid[i][j] > 9 || grid[i][j] < 1) return false;
                set.add(grid[i][j]);
            }
        }
        return set.size() == 9;
    }

}