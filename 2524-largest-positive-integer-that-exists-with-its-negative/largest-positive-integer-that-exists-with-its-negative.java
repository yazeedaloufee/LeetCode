class Solution {
    public int findMaxK(int[] nums) {
        
        int result = -1;
        int maxVal = 0;
        for(int num: nums) {
            if(num > 0 && num > maxVal && checkNegExists(nums, -1*num)) {
                maxVal = num;
                result = maxVal;
            }
        }
        return result;
    }

    public boolean checkNegExists(int[] nums, int k) {
        for(int num: nums) {
            if(k == num) {
                return true;
            }
        }
        return false;
    }

}
