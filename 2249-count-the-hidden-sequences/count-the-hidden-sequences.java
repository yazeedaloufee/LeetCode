class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0, max = 0;
        int start = 0; 
        for(int i : differences) {
            start = (start + i)%1000000007;
            min = Math.min(min, start );
            max = Math.max(max, start );
        }
        int range = max - min;
        max = range + lower;
        min  = lower;
        // min = min + lower;
        // max = max + lower;

        if(upper < max) return 0; 

        return upper - max + 1;
    }
}