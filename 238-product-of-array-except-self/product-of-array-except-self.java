class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] productFromRight = new int[n];
        int[] productFromLeft = new int[n];
        int product = 1;
        for(int i = 1; i < n; i++) {
            product *= nums[i-1];
            productFromLeft[i] = product;
        }
        product =1;
        
        for(int i = n-2; i >= 0; i--) {
            product *= nums[i+1];
            productFromRight[i] = product;
        }
        int[] output = new int[n];
        output[0] = productFromRight[0];
        output[n-1] = productFromLeft[n-1];
        for(int i = 1; i < n -1 ; i++){
            output[i] = productFromLeft[i]*productFromRight[i];
        }
        return output;
    }
    // [1,2,3,4]
    // [1,2,6,24]
    // [0,0,0,4]
}