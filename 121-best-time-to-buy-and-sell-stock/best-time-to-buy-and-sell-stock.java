class Solution {
    public int maxProfit(int[] prices) {
        int[] maxFromRight = new int[prices.length];
        maxFromRight[prices.length- 1] = 0; 

        for(int i = prices.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], prices[i + 1]);
            
        }
        int max = 0; 
        for(int i = 0; i < prices.length - 1;i++) {
            max = Math.max(-prices[i] + maxFromRight[i], max); 
        }
        return max;
        
    }
}