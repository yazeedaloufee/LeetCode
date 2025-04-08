class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = properties.length;
        for(int i = 0;i<n;i++) graph.add(new ArrayList<>());
        for(int i = 0;i< n ;i++){
            for(int j = 0; j<n ; j++)
                if(intersect(properties[i],properties[j]) >=k ){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0 ; i< n;i++){
            if(!visited[i]){
                dfs(graph,i,visited); res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> graph, int cur,boolean[] visited) {
        visited[cur] = true;
        for(int nei : graph.get(cur)){
            if(!visited[nei]) dfs(graph,nei,visited);
        }
    }

    int intersect(int[] a,int[] b){
        boolean[] a1 = new boolean[101];
        boolean[] b1 = new boolean[101];
        for(int i : a){
            a1[i] = true;
        }
        for (int n:b)  b1[n] = true;
        int res = 0;
        for(int i = 1;i<101;i++) if (a1[i] && b1[i]) res++;
        return res;
    }
}