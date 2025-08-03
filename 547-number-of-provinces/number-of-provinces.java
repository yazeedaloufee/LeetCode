class Solution {

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        int output = 0; 
        for (int i = 0; i < length; i++) {
            if(!visited[i]){
                output++;
                dfs(i, isConnected, visited);
            }
        }
        return output;
    }

    public void dfs(int i,int[][] isConnected, boolean[] visited ) {
        visited[i] = true;

        for (int j = 0 ; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j] ){
                dfs(j, isConnected, visited);
            }
        }
    }
}