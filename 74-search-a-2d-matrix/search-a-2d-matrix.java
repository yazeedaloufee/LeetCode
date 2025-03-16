class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0; 
        int r = matrix[0].length* matrix.length - 1;

        while(l <= r) {
            int mid = (r + l )/2;
            if (matrix[mid/cols][mid%cols] == target){
                return true;
            } else if(matrix[mid/cols][mid%cols] < target )  {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
        
    }
}