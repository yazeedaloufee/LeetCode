class Solution {
    Set<Integer> terminal;
    List<Integer> output;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        terminal = new HashSet<>();
        output = new ArrayList<>();
        for(int i  = 0; i < graph.length; i++) {
            if(graph[i].length == 0){
                terminal.add(i);
            }
        }
        int[] state = new int[graph.length];
        for (int i = 0;i < graph.length; i++) {
            if(dfs(i, state, graph)) {
                output.add(i);
            }
        }
        return output;
    }

    public boolean dfs(int node, int[] state, int[][] graph) {
        if(state[node] == 1) return false; 
        if(state[node] == 2 || isTerminal(node)) return true;
        state[node] = 1;

        for(int neighbor : graph[node]){
            if(!dfs(neighbor, state, graph)){
                return false;
            }
        }
        state[node] = 2; 
        return true;

    }

    private boolean isTerminal(int i ) {
        if(terminal.contains(i)){
            return true;
        }
        return false;
    }
}