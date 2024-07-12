class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> temp = new ArrayList<>();
        // 
        int[] curr = new int[2];

        for(int i = 0; i < intervals.length;) {
            curr = intervals[i];
            while(i < intervals.length && intervals[i][0] <= curr[1]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
                i++;
            }
            temp.add(curr);
        }

        int[][] output = new int[temp.size()][2];
        for(int j = 0; j < temp.size(); j++) {
            output[j] = temp.get(j);
        }
        return output;
    }
}