class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        Set<Integer> visited = new HashSet<>();

        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.add(path);

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int node = currentPath.get(currentPath.size() - 1);

            for (int nextNode : graph[node]) {
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(nextNode);

                if (nextNode == graph.length - 1) {
                    output.add(new ArrayList<>(newPath));
                } else {
                    queue.add(newPath);
                }
            }
        }
        return output;
    }
}