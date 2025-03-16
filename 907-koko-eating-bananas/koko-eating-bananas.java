class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; 
        int r = Integer.MAX_VALUE;
        while(l < r) {
            int mid = l + (r - l) / 2;
            int time = calculateTime(piles, mid, h);
            if (time <= h){
                r = mid;
            } else {
                l = mid +1;
            }
        }

        return r;
    }
    private int calculateTime(int[] piles, int k , int h) {
        int time = 0; 

        for (int pile : piles) {
            time+=pile/k;
            if(pile % k > 0) time++;
        }
        return time;
    }
}