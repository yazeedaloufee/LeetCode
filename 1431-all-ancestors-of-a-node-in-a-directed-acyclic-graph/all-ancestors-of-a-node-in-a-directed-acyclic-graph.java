import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            output.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            graph.get(dest).add(source);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, output, visited);
            }
        }

        return output;
    }

    private List<Integer> dfs(int start, List<List<Integer>> graph, List<List<Integer>> output, boolean[] visited) {
        if (visited[start]) return output.get(start);

        Set<Integer> ancestors = new HashSet<>();

        for (int neighbor : graph.get(start)) {
            ancestors.add(neighbor);
            for (int ancestor : dfs(neighbor, graph, output, visited)) {
                ancestors.add(ancestor);
            }
        }

        List<Integer> ancestorList = new ArrayList<>(ancestors);
        Collections.sort(ancestorList);
        output.get(start).addAll(ancestorList);

        visited[start] = true;
        return ancestorList;
    }
}
