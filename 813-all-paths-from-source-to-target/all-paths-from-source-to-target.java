class Solution {
    List<List<Integer>> output = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // build adjacency list
        this.graph = graph;
        if( graph == null || graph.length == 0 ) return output;
        dfs(0, new ArrayList<>());
        return output;
    }

    private void dfs(int current, ArrayList<Integer> path){
        path.add(current);

        if (current == graph.length - 1) {
            pushToOutput(path);
        }

        for (int child : graph[current]) {
            dfs(child, path);
        }

        path.removeLast();
    }

    private void pushToOutput(ArrayList<Integer> list) {
        List<Integer> push = new ArrayList<>();
        for(int i : list) {
            push.add(i);
        }
        output.add(push);
    }
}