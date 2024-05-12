class Solution {
    int[][] values = new int[][]{{1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}, {0, 0}  };
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int[][] result = new int[length -2][width - 2];

        for(int i = 1; i < length - 1; i++) {
            for(int j = 1; j < width - 1; j++) {
                result[i-1][j-1] = helper(j, i, grid);
            }
        }
        return result;
        
    }

    private int helper (int x, int y, int[][] array) {
        int max = 0; 

        for(int[] v : values) {
            max = Math.max(max,array[y+ v[0]][ x + v[1]]);

        }
        System.out.println("x = "+ x + ", y = "+ y);
        System.out.println(max);
        return max;

    }
}