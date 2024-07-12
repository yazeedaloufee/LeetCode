class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int output = 0; 
        if(intervals.length == 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] temp = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if(temp[1] > intervals[i][0]){
                if(temp[1] > intervals[i][1]){
                    temp =intervals[i]; 
                }
                output++;
            }else {
                temp = intervals[i];
            }
        }
        return output;
    }
}