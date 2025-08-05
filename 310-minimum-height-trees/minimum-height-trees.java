class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        if(n == 1) {
            List<Integer> output = new ArrayList<>();
            output.add(0);
            return output;
        }
        for(int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for(int[] pair : edges) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n ;i++) {
            if(graph.get(i).size() == 1) {
                leaves .add(i);
            }
        }
        while(n > 2) {
            n-=leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                int neighbor = graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if(graph.get(neighbor).size() == 1) {   
                    newLeaves.add(neighbor);
                }
            }
            leaves=newLeaves;
        }
        return leaves;
    }
}