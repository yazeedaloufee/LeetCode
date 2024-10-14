class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> hm = new HashMap<>();

        // Build adjacency list
        for (int[] edge : edges) {
            int parentV = edge[0];
            int childV = edge[1];
            hm.computeIfAbsent(parentV, k -> new ArrayList<>()).add(childV);
            hm.computeIfAbsent(childV, k -> new ArrayList<>()).add(parentV);
        }

        // Call DFS to check if a valid path exists
        return dfs(source, destination, hm, new HashSet<>());
    }

    private boolean dfs(int source, int destination, Map<Integer, List<Integer>> hm, Set<Integer> visited) {
        // If the source is already visited, return false
        if (visited.contains(source)) return false;

        // Mark the node as visited
        visited.add(source);

        // Get the adjacent nodes (children) of the source
        List<Integer> children = hm.getOrDefault(source, new ArrayList<>());

        // Iterate over the children
        for (int child : children) {
            // If we find the destination node, return true
            if (child == destination) return true;

            // Recursively check for the path in the child's DFS
            if (dfs(child, destination, hm, visited)) return true;
        }

        // If no path is found, return false
        return false;
    }
}
