class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] trusts = new int[n+1][2];

        for(int[] r : trust) {
            int a = r[0];
            int b= r[1];
            trusts[a][1]++;
            trusts[b][0]++;
        }

        for(int i = 1; i < n + 1 ;i++) {
            if(trusts[i][0] == n-1 && trusts[i][1]==0) return i;
        }
        return -1;
        
    }
}

//{peopletrust in me, i trust in people}