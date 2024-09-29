import java.util.*;

class Solution {
    boolean[] visited; // Track the visitation status of courses
    boolean[] inRecStack; // Track the current recursion stack
    Map<Integer, List<Integer>> hm; // Adjacency list for prerequisites

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hm = new HashMap<>();
        visited = new boolean[numCourses];
        inRecStack = new boolean[numCourses]; // Initialize recursion stack

        // Build the adjacency list
        for (int[] pair : prerequisites) {
            hm.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }

        // Perform DFS on each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(i)) {
                return false; // Cycle detected
            }
        }
        return true; // All courses can be finished
    }

    private boolean dfs(int x) {
        if (inRecStack[x]) return false; // Cycle detected
        if (visited[x]) return true; // Already processed

        visited[x] = true;
        inRecStack[x] = true; // Add to recursion stack
        List<Integer> children = hm.get(x);

        if (children != null) {
            for (int n : children) {
                if (!dfs(n)) {
                    return false; // Cycle detected in DFS
                }
            }
        }
        inRecStack[x] = false; // Remove from recursion stack
        return true; // No cycle found
    }
}
