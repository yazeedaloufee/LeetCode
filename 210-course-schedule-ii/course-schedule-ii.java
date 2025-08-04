import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int[] state = new int[numCourses];  // 0 = unvisited, 1 = visiting, 2 = visited
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state, output)) {
                    return new int[0];  // cycle detected
                }
            }
        }

        Collections.reverse(output);
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, int[] state, List<Integer> output) {
        if (state[node] == 1) return false; // cycle detected
        if (state[node] == 2) return true;  // already visited

        state[node] = 1; // mark as visiting
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(neighbor, graph, state, output)) {
                return false;
            }
        }

        state[node] = 2; // mark as visited
        output.add(node);
        return true;
    }
}
