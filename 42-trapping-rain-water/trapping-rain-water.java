class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] maxFromRight = new int[length];
        int[] maxFromLeft = new int[length];
        maxFromLeft[0] = 0; 
        for (int i = 1; i < length; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i -1]);
        }
        maxFromRight[length - 1] = 0;
        
        for (int i = length - 2; i >=0 ; i--) {
            maxFromRight[i] = Math.max(height[i+1], maxFromRight[i+1]);
        }
        
        int water = 0; 

        for(int i = 1; i < length; i++) {
            if( Math.min(maxFromRight[i], maxFromLeft[i]) > height[i])
            water += Math.min(maxFromRight[i], maxFromLeft[i])- height[i];
        }
        return water;
        
        
    }
}