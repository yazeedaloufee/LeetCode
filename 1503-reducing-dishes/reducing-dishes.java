class Solution {
    int[] sat; 
    int[][]memo;
    public int maxSatisfaction(int[] satisfaction) {
        // [-1,-8,0,5,-9]
        // TAKE => -1 => 
        
        sat = satisfaction;
        Arrays.sort(sat);
        memo = new int[sat.length+1][sat.length+2];

        for(int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return dp(0,1);
    }

    private int dp(int index, int position) {

        if (memo[index][position] != -1) {
            return memo[index][position];
        }
        if(index >= sat.length || position > sat.length) return 0;
        
        memo[index][position] = Math.max(sat[index] * position+ dp(index + 1,  position+1), dp(index + 1,  position) ); 
        return memo[index][position];
    }
}