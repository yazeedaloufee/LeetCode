class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] courses : prerequisites) {
            int course = courses[0];
            int prereq = courses[1];
            adjList.computeIfAbsent(prereq, x -> new HashSet<>()).add(course);
            inDegree[course]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int course = q.poll();
            order.add(course);

            for (int dependent : adjList.getOrDefault(course, new HashSet<>())) {
                inDegree[dependent]--;
                if (inDegree[dependent] == 0) {
                    q.add(dependent);
                }
            }
        }

        if (order.size() != numCourses) {
            return new int[0];
        }

        return order.stream().mapToInt(Integer::intValue).toArray();
    }
}
