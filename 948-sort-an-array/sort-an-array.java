class Solution {
    public int[] sortArray(int[] nums) {
        doubleQuickSort(nums,0, nums.length - 1);
        return nums;
    }
     private void doubleQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int[] pivots = partition(array, low, high);

            doubleQuickSort(array, low, pivots[0] - 1);
            doubleQuickSort(array, pivots[0] + 1, pivots[1] - 1);
            doubleQuickSort(array, pivots[1] + 1, high);
        }
    }

    private int[] partition(int[] array, int low, int high) {
        if (array[low] > array[high]) {
            swap(array, low, high);
        }

        int leftPivot = array[low];
        int rightPivot = array[high];

        int lessThan = low + 1;
        int moreThan = high - 1;

        // Using a for-loop instead of while
        for (int i = low + 1; i <= moreThan; ) {
            if (array[i] < leftPivot) {
                swap(array, i, lessThan);
                lessThan++;
                i++; // Move forward
            } else if (array[i] > rightPivot) {
                swap(array, i, moreThan);
                moreThan--; // Don't increment i here, because we need to check the swapped element
            } else {
                i++; // Move forward if element is between pivots
            }
        }

        // Swap pivots into their correct positions
        swap(array, low, --lessThan);
        swap(array, high, ++moreThan);

        return new int[]{lessThan, moreThan};
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}